package finalproject.menu;

import java.util.Scanner;

import finalproject.Premium;

public class Option4 {
	   /*****
     * Method: Option4
     * @return totalCost - the value is returned to the main method
     * Description: In this method, the class premium is
     * used to calculate the cost, which is then printed to the file "Profile.txt"
     ****/
    public static double option4()
    {
        Premium buy = new Premium();//class
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        //declaring variable 
        String info;
        double plans; 
        int choice;
        double totalCost;
        
            System.out.println("Become a permium member and have full access"
                    + " to the song recommender");
            System.out.println("What plan do you want");
            System.out.println("1.Week plan: $50.99"
                               + "\n2.Monthly plan: $100.50" 
                               + "\n3.Yearly plan: $250.99"
                               + "\nNOTE: Please enter the number");
            choice = scanN.nextInt();
            
            //error trap
            while (choice < 1 || choice > 3) 
            {
                System.out.println("Invalid Choice! "
                        + "Please enter a valid plan number (1, 2, or 3):");
                choice = scanN.nextInt();
            }
            
            if (choice == 1)
            {
            plans = 50.99;
            }//end of if statement 
            else if (choice == 2)
            {
            plans = 100.50;
            }//end of else if statement
            else 
            {
            plans = 250.99;
            }//end of else statement 
            
            buy.setpremium(plans);
            totalCost = buy.calcutax(); // Calculate the total cost including tax

            System.out.println("Buying Membership......");
            System.out.println("Please enter your payment information: ");
            info = scanS.nextLine();
        
        
        return totalCost; // Return the total cost
    }//end of option4

}
