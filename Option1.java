package finalproject.menu;

import java.io.*;
import java.util.*;
import sound.*;

public class Option1 
{
    public static void option1(String[] genre) throws InterruptedException
    {
    	Scanner scan = new Scanner(System.in);
    	
        //Declaring Variables
        String Choice;
        boolean isValidChoice;
        FileWriter fw;
        PrintWriter pw; 
        String like;
        String songName = "";
        String file = "";
        
        MusicPlayer player = null; // Declare player here so we can access it later
     
        System.out.println("The genre available are: ");
        
        //for loop to print the genre array 
        for(int i = 0; i <genre.length;i++)
        {
            System.out.println("- " + genre[i]);
        }//end of for loop
        
        
        //start of do..while loop
        do 
        {
            System.out.println("Please choose a genre (enter the name be specific): ");
            Choice = scan.nextLine().trim().toLowerCase();
         
            // Error trap
            isValidChoice = false;
            for (String i : genre)
            {
                if (Choice.equalsIgnoreCase(i))//compare
                {
                    isValidChoice = true;
                    break;
                }
            }
            if (!isValidChoice) 
            {
                System.out.println();
                System.out.println("Invalid choice!! Please enter one of the options above.");
            }
        }while (!isValidChoice);
        //end of do..while loop 
        
        switch (Choice.toLowerCase())
        {
        case "kpop":
            player = new KpopPlayer();
            break;

        case "pop":
            player = new PopPlayer();
            break;

        case "classic":
            player = new ClassicPlayer();
            break;

        case "rap":
            player = new RapPlayer();
            break;
         }
        
        player.loadSongs();
        
        do
        {
        	
        	String[] song = player.getRandomSong();
        	songName = song[0];
        	file = song [1];
        	
        	System.out.println("\nPlaying: " + songName);
        	
        	try
        	{
        		player.playSong(file);
        	}
        	catch(Exception e)
        	{
        		System.out.print("Audio Error: " + e.getMessage());
        	}
        	
        	System.out.println("Do you like the song? (yes/no)");
        	like = scan.nextLine();
        	
        	while(!like.equalsIgnoreCase("yes") && !like.equalsIgnoreCase("no"))
        	{
        		System.out.println("Please enter only yes/no:");
        		like = scan.nextLine();
        		
        	}
        	if(like.equalsIgnoreCase("Yes"))
            {
        		player.stopSong();
            }//end of if statement 
            else if(like.equalsIgnoreCase("No"))
            {
            	player.stopSong();
            }//end of else if           
        
        }while(like.equalsIgnoreCase("no"));
        
        player.stopSong();
        System.out.println("Music stopped.");
       
        
        try
        {
        	Thread.sleep(500);
        	fw = new FileWriter("Genresongs.txt", true);
        	pw = new PrintWriter(fw);
        	
        	pw.println("Genre: " + Choice);
        	pw.println("Song: " + songName);
        	pw.println();
        	
        	pw.close();
        }
        catch(IOException e)
        {
        	System.out.println("File error: " + e.getMessage());
        }
        
        System.out.println("Your information has been saved to the file. 😊\n");
        
      }//end of Option1
}