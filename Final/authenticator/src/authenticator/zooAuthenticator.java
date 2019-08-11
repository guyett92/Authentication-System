/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authenticator;

import java.util.*;
import java.net.URL;
import java.security.*;
import java.io.*;


/**
 *
 * @author Aaron Guyett
 */
public class zooAuthenticator {
    public static ArrayList<String> username = new ArrayList<String>();
    public static ArrayList<String> password = new ArrayList<String>();
    public static ArrayList<String> md5 = new ArrayList<String>();
    public static ArrayList<String> position = new ArrayList<String>;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoSuchAlgorithmException {
        readCredFile();
        prompts();
    }
        public static boolean passwordVerification() throws NoSuchAlgorithmException {
            if (username.contains(userCreds.getName())) {
                int slot = username.indexOf(userCreds.getName());
                String pwhash = md5.get(slot).toString();
                
                if (pwhash.equals(userCreds.getMD5())) {
                    return true;
                } else {
                    System.out.println("Passwords do not match.");
                    return false;
                }
            } else {
                System.out.println("Username does not exist.");
                return false;
            }
        }
        public static void readCredFile() throws IOException {
            URL path = authenticationSystem.class.getResource("credentials.txt");
            File f = new File(path.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            
            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    //Split line on tabs
                    String[] array = line.split("\\t");
                    //Read username
                    username.add(array[0]);
                    //Read MD5
                    md5.add(array[1]);
                    //Read password
                    String trimpw = array[2].replace("\"", "");
                    password.add(trimpw);
                    //Read position
                    position.add(array[3]);
                }
            }
            reader.close();
        }
        public static void logout() {
            System.out.println("Thank you for using the system. Have a nice day!");
            system.ext(0);
        }
        
        public static void displayPosition() throws IOException {
            int slot = username.indexOf(userCreds.getName());
            String positionFile = position.get(slot).toString();
            
            URL path = zooAuthenticator.class.getResource("credentials.txt");
            File f = new File(path.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            
            if (positionFile.equals("admin")) {
                path = zooAuthenticator.class.getResource("admin.txt");
                f = new File(path.getFile());
                reader = new BufferedReader(new FileReader(f));
                line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.length() > 0) {
                        System.out.println(line);
                    }
                }
            }
            if (positionFile.equals("zookeeper")) {
                path = zooAuthenticator.class.getResource("zookeeper.txt");
                f = new File(path.getFile());
                reader = new BufferedReader(new FileReader(f));
                line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.length() > 0) {
                        System.out.println(line);
                    }
                }
            }
            if (positionFile.equals("veterinarian")) {
                path.zooAuthenticator.class.getResource("veterinarian.txt");
                f = new File(path.getFile());
                reader = new BufferedReader(new FileReader(f));
                line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.length() > 0) {
                        System.out.println(line);
                }
            }
    }
            reader.close();
}
        public static void prompts() throws NoSuchAlgorithmException, IOException {
            // Prompt then accept the username and password
            Scanner scnr = new Scanner(System.in);
            while (true) {
                int logChoice = 0;
                while (true) {
                    try {
                        System.out.print("\nWhat would you like to do?\n1) Log in\n2) log out\nEntry: ");
                        logChoice = Integer.parseInt(scnr.nextLine());
                        break;                   
                    } catch (NumberFormatException ne) {
                        System.out.println("Input is not a number. Please attempt again.");
                    }
                }
                if (logChoice == 1) {
                    int count = 0;
                    // Checks password
                    while (count < 3) {
                        System.out.print("Username: ");
                        userCreds.setName(scnr.nextLine().trim());
                        System.out.print("Password: ");
                        userCreds.setPasswd(scnr.nextLine().trim());
                        if (passwordCheck() == true) {
                            displayPosition();
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == 3) {
                        System.out.println("You have attempted to login the maximum number of tries.");
                        System.exit(0);
                    }
                } else if (logChoice == 2) {
                    logout();
                } else {
                    System.out.println("Does not work. Try again.");
                }
            }
        }
    
}
