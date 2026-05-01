package finalproject.menu;

import java.io.*;
import java.util.*;

public class Option3 {
	/**
     * Method: Option3
     * Description: In this method, the user can change their profile.
     * Which is then saved to the file "Prof  ile.txt".
     */
    public static void option3()
    {
        Scanner scan = new Scanner(System.in);
        FileWriter fw;
        PrintWriter pw; 
        //declaring variables
        String Name, Email, Phone; 
                
        System.out.println("Updating Profile..........");
        
        //start of try..catch
        try
        {
            fw = new FileWriter("Profile.txt", false);
            pw = new PrintWriter(fw);
            System.out.println("What is your name: ");
            Name = scan.nextLine();
            System.out.println("✉️ What is your email address: ");
            Email = scan.nextLine();
            
            while(!Email.contains("@"))
            {
            	System.out.println("⛔ Please enter your email address with '@': ");
            	Email = scan.nextLine();
            }
            
            System.out.println("📞 What is your phone number(xxx-xxx-xxxx): ");
            Phone = scan.nextLine();
            
            //error...trap if the phone number are digits or not
            while(!Phone.matches("\\d{3}-\\d{3}-\\d{4}"))
            {
            	 System.out.println("⛔ Invalid format. Please enter phone number as xxx-xxx-xxxx: ");
                 Phone = scan.nextLine();
            }
            
            pw.println();
            System.out.println("Your profile has been saved in the file successfully.");
            System.out.println();
            pw.close();
            
        }//end of try 
        catch(IOException e)
        {
            System.out.println("File Error! " + e.getMessage());
        }//end of catch 
      }//end of Option3

}
