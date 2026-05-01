package finalproject.menu;

import java.io.*;
import java.util.Scanner;

public class Option5 {
	/***
     * Description - In this code, It allows the User to write a review 
     * on the song recommender for future reference for the customer, 
     * which is then printed in a File called "FeedBack.txt"
     */
    public static void option5()
    {
        Scanner scanS = new Scanner(System.in);
        FileWriter fw;
        PrintWriter pw;
        
        //Declaring Variable 
        String FeedBack;
        
        //Start of try...catch
        try
        {
            fw = new FileWriter("FeedBack.txt", true);//Appending File
            pw = new PrintWriter(fw);
            
            System.out.println("Please write a review on the App ");
            FeedBack = scanS.nextLine();
            System.out.println();
            
            pw.println(FeedBack);
            pw.close();//PrintWriter closed 
                    
        }//end of try 
        catch(IOException e)
        {
            //error message 
            System.out.println("File Error!!!" +e.getMessage());
        }//end of catch 
    }//end of Option5

}
