/**************************************
 *Project: FinalProject               
 *Programmer : Anousha, Nitasha & Zaynab  
 *Date: 11 Nov 2025
 *Program Name: FinalProject.java 
 **************************************/
package finalproject;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.sound.sampled.*; 
import finalproject.menu.*;

public class FinalProject 
{
	public static Clip clip;
    
    public static void main(String[] args) throws InterruptedException 
    {
        Scanner scan = new Scanner(System.in);
        Premium buy = new Premium();
        DecimalFormat twoDigit = new DecimalFormat("0.00");
        FileWriter fw;
        PrintWriter pw;
        FileWriter fn;
        PrintWriter pn;
        
        //Declaring Variables
        String[] genre = {"Kpop","Classic", "Pop", "Rap"};
        String[] artists = {"Jungkook", "Weeknd", "Drake", "Alan Milan"};
        double price;
        int menu;
        String Name, Email, Phone; 
         
       
        for(int rows = 0;rows <=5; rows++)
        {//;start of the for loop 
            for(int col = 0; col <=100; col++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }//end of for loop 
        
        //introduction
        System.out.println("🎶 Welcome to the AI - music recommender");
        System.out.println("Hi, I am Anis. 😊");
        System.out.println("I will be helping you find a song "
                + "which matches your taste.");
        System.out.println("LET's BEGIN!!!");

        
        //start of try...catch
        try
        {
            //Making Profile
            fw = new FileWriter("Profile.txt", true);
            pw = new PrintWriter(fw);
            System.out.println("Firstly, make a profile");
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
            System.out.println("Your profile has been saved in the file successfully. 😊");
            System.out.println();
            
            pw.close();
            
            //start of the do...while loop
            do
            {
                System.out.println("In the menu below select one of the options");
                System.out.println("1. select a Genre"
                    + "\n2. listen to a specfic artist"
                    + "\n3. change your profile"
                    + "\n4. buy premium"
                    + "\n5. write a review"
                    + "\n6. Read Previous Customers Feedback"
                    + "\n7. Exit!!!");
                System.out.println("Note: Please Only enter The Number: ");
                menu = scan.nextInt();
                System.out.println();
                
                //error trap
                while(menu > 7 || menu <1) 
                {
                    System.out.println("⛔ Invalid Choice!! Please Enter on of the "
                        + "options above(ENTER A NUMBER): ");
                    menu = scan.nextInt();
                    System.out.println();
                }
                
                
                //start of switch(menu)
                switch(menu)
                {
                    case 1:
                    {
                    	Option1.option1(genre);
                        break;
                    }//end of case1
                    
                    case 2:
                {
                        Option2.option2(artists);
                        break;
                    }//end of case2
                    
                    case 3:
                    {
                        Option3.option3();
                        break;
                    }//end of case3
                    
                    case 4:
                    {
                        price = Option4.option4();
                        pw.println("Premium Fee: $" + twoDigit.format(price));//prints the Premium fee.
                        System.out.println("Your payment has successfully been"
                                               + " saved in the file");
                        System.out.println();
                        break;
                    }//end of case4
                    
                    case 5:
                    {
                        Option5.option5();
                        break;
                    }//end of case5
                            
                    case 6:
                    {
                        Option6.option6();

                        break;
                    }//end of case6
                    case 7:
                        Recommender.getRecommendation();  
                        break;
                    case 8:
                    {
                    System.out.println("➡️ Exiting...");
                    break;
                    }//end case7
                    
                }//end of switch(menu)
                
            }while(menu != 7);//end of the do....while loop
            
             System.out.println("Hope you found the song you like");
             System.out.println("Hope you have a great day!!!");
             System.out.println("BYEEE!!! 👋😊");            
             
        }// end of try
        catch(IOException e)
        {
            System.out.println("File Error! " + e.getMessage());
        }//end of catch
        catch(InputMismatchException e)
        {
            System.out.println("Error! " + e.getMessage());
        }//end of catch
        
    }//end of main method 
}