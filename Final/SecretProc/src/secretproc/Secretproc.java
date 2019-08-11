//Include libraries

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import java.util.Scanner;

import java.io.FileNotFoundException;

//Define a class Secretproc

public class Secretproc

{

     //Define main

     public static void main(String[] args) throws IOException

     {

          //Call method

          loginScreenpro();

     }

     //Define a method

     public static void loginScreenpro()

     {

          //Define string variable

          String gPassword = "";            

          //Declare variables

          int flag123 = 0,attempts123=3;

          //Define reader

BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));     

          //Display message

          System.out.println("\nLogin");

          //Try block

          try

          {

              //Do

              do

              {

                   //Decrement value

                   attempts123--;

                   //Display message

                   System.out.println("Enter Username");

                   //Store value

                   String userName = br1.readLine();

                   //Display message

                   System.out.println("Enter Password");

                   //Store value

                   String password = br1.readLine();

                   //Create an instance

MessageDigest md123 = MessageDigest.getInstance("md5");

                   //Update

                   md123.update(password.getBytes());

                   //Call method

                   byte[] bytes12 = md123.digest();

                   //Create an instance

                   StringBuilder lSb1 = new StringBuilder();

                   //Loop

                   for (int k = 0; k < bytes12.length; k++)

                   {

                        //Append

lSb1.append(Integer.toString((bytes12[k] & 0xff) + 0x100, 16).substring(1));

                   }

                   //Generate password

                   gPassword = lSb1.toString();

                   //Declare variable

                   String currentLine;

                   //Define an instance

BufferedReader bin123 = new BufferedReader(new FileReader("Credentials.txt"));

                    //Loop until end of file

                   while ((currentLine = bin123.readLine()) !=                             null)

                   {                 

                        //Split each line of file

String[] array123 = currentLine.split("\t");

                        // If user name matches

                        if (array123[0].equals(userName))

                        {

                             //If password matches

                             if (array123[1].equals(gPassword))

                             {                           

                                  //Store file name                              

                                  String x = array123[3];

                                  //Define file reader

                                  BufferedReader br2 = null;

                                  //Declare variable

                                  String strLine1 = "";

                                  //Open file

br2 = new BufferedReader( new FileReader(x+".txt"));

                                  //Loop until file end

while( (strLine1 = br2.readLine()) != null)

                                  {

                                      //Display contents

                                                                                   System.out.println(strLine1);

                                  }

    

                                  //Assign value

                                  flag123 = 1;

                                  //Break

                                  break;

                             }

                        }

                   }

                   //If attempt is 0

                   if(attempts123==0)

                   {

                        //Display message

                        System.out.println("login more times");

                        //Display message

                        System.out.println("Exit...");

                        //Exit

                        System.exit(1);

                   }

             

                   //If flag is 1

                   if (flag123 == 1)

                   {

                        //Call method

                        adminScreenpro();

                        //Break

                        break;

                   }

                   //Otherwise

                   else

                   {

                        //Display message

System.out.println("Invalid Username or Password.");

                        //Display message

                        System.out.println(" try again.");                   

                        //Display message

System.out.println(attempts123+" more attemptes left.\n");

                   }

              }

              //Loop

              while(attempts123>0);

          }

          //Define catch

          catch (NoSuchAlgorithmException e1)

          {

              //Trace

              e1.printStackTrace();

          }

          //Define catch block

          catch (IOException e1)

          {

              //Trace

              e1.printStackTrace();

          }

     }

     //Define a method

     public static void adminScreenpro()

     {

          //Declare variable  

          String logOut123;

          //Define scanner variable

          Scanner sc1= new Scanner(System.in);

          //Display message

          System.out.println("\nWelcome Admin");       

          //Display message

          System.out.println("user Press 99 for log out\n");

          //Do loop

          do

          {

              //Store value

              logOut123 = sc1.nextLine();

          }

          //Loop

          while(!logOut123.equals("99"));

          //If value is 99

          if(logOut123.equals("99"))

          {

              //Call method

              loginScreenpro();

          }

     }

}