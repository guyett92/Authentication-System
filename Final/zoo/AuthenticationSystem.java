import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;


public class AuthenticationSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {

        Scanner scnr;
        scnr = new Scanner(new File("\Users\aaron\Desktop\Foundations in App Development\Final\AuthenticationSystem\src"));
        String credentials[][] = new String[100][4];
        int count = 0;

        while (scnr.hasNextLine()) {

            String line = scnr.nextLine();

            credentials[count][0] = line.substring(0, 20).trim();
            credentials[count][1] = line.substring(20, 55).trim();
            credentials[count][2] = line.substring(55, 74).trim();
            credentials[count][3] = line.substring(74).trim();
            count++;
        }

        Scanner input = new Scanner(System.in);
        boolean run = true;
        int tries = 0;

        while (run) {
            System.out.println("-Welcome-");
            System.out.println("1-Login");
            System.out.println("2-Exit");

            int ch = Integer.parseInt(input.nextLine().trim());

            if (ch == 1) {
//increment number of attempts
                tries++;
//request username and password
                System.out.print("Enter Username: ");
                String username = input.nextLine();
                System.out.print("Enter Password: ");
                String password = input.nextLine();
//generate hash
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                String hPassword = sb.toString();

                boolean badUser = true;

                for (int i = 0; i < count; i++) {
                    if (username.contentEquals(credentials[i][0])) {
                        if (hPassword.contentEquals(credentials[i][1])) {
//if verified, logged in
                            List<String> data = null;
//check type of user and print
                            switch (credentials[i][3]) {
                                case "zookeeper":
                                    data = Files.readAllLines(Paths.get("zookeeper.txt"), Charset.defaultCharset());
                                    break;
                                case "admin":
                                    data = Files.readAllLines(Paths.get("admin.txt"), Charset.defaultCharset());
                                    break;
                                case "veterinarian":
                                    data = Files.readAllLines(Paths.get("veterinarian.txt"), Charset.defaultCharset());
                                    break;
                                default:
                                    break;
                            }
                            if (data != null) {
                                for (String s : data) {
                                    System.out.println(s);
                                }
                            }
//reset
                            tries = 0;

                            System.out.println("\n1) Logout.");
                            System.out.println("2) Exit.");

                            ch = Integer.parseInt(input.nextLine().trim());
                            if (ch == 2) {
                                run = false;
                            }
                            badUser = false;
                            break;
                        }
                    }
                }
                if (badUser) {
                    System.out.println("Invalid Username or password.");
                }
            } else {
                break;
            }
//limit attempts
            if (tries == 3) {
                run = false;
                System.out.println("You have exceeded the number of login attempts.");
            }
        }

    }
}