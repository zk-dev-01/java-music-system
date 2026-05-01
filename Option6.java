package finalproject.menu;

import java.io.*;
import java.util.*;

public class Option6 {
	 
	
	/**
     * Description - In this code, It access the File "FeedBack.txt" so that
     * it can print out the the customers review in Eclipse.
     **/
    public static void option6()
    {
        //Declarign Variable 
        File fw;
        Scanner scanS;
        
        //Declaring Variable 
        String FeedBack;
        
        //Start of try...catch 
        try
        {
          fw = new File("FeedBack.txt");
          scanS = new Scanner(fw);
          
          System.out.println("Customer feedback history: ");
            System.out.println();
          while(scanS.hasNext())
          {
              FeedBack = scanS.nextLine();
              System.out.println(FeedBack + "\n");
              
          }//end of while loop 
          scanS.close();//scanner closed
        }//end of try 
        catch(IOException e)
        {
            //error message 
            System.out.println("File Error!!!" + e.getMessage());
        }//end of catch
    }//end of Option6

}
