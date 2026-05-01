package finalproject.menu;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

import sound.*;

public class Option2 {
    
	public static Clip clip;
    
    /****
    * Method: Option2 
    * @param artists - a single array is used to hold name of the artists.
    * Description - In this method, It allows the User to choose one of the
    * artists in the array, which then is transferred to the sub - methods.
    * After that the name of the song is returned to the method-option2 to print
    * the name of the song and artist in a file "Artistsongs.txt".
     * @throws InterruptedException 
    *****/
   public static void option2(String[] artists) throws InterruptedException
   {
       Scanner scan = new Scanner(System.in);
       
       //declaring variable 
       String Choice, like;
       boolean isValidChoice;
       String t, j, s, m;
       FileWriter fw;
       PrintWriter pw; 
       
       String songName = "";
       String file = "";
       ArtistPlayer player = null;
       
       sortArtists(artists);
       
       System.out.println("The artists available are: ");
       
       for(int i = 0; i <artists.length;i++)
       {
           System.out.println("- " + artists[i]);
       }//end of for loop 
       
       do
       {
           System.out.println("Please choose a artist (enter the name be specific): ");
           Choice = scan.nextLine();
               
               //error trap
               isValidChoice = false;
               for (String i : artists)
               {
                   if (Choice.equalsIgnoreCase(i))
                   {
                       isValidChoice = true;
                       break;
                   }//end if statement 
               }//end of for loop 
               
               if (!isValidChoice)
               {
                   System.out.println("Invalid choice!! "
                           + "Please enter one of the options above.");
               }//end if statement 
           } while (!isValidChoice);
       
     //start of switch(Choice)         
       switch(Choice)
       {
           case "Weeknd":
           case "weeknd":
           {
               player = new WeekndPlayer();
               break;
           }//end of case Taylor
           
           case "Jungkook":
           case "jungkook":
           {
        	   player = new JungkookPlayer();
               break;
           }//end of case Jungkook
           
           case "Drake":
           case "drake":
           {
        	   player = new DrakePlayer();
        	   break;
           }//end of case Taehyung
           
           case "Alan Milan":
           case "alan milan":
           case "Alan milan":
           case "alan Milan":
           {
        	   player = new AlanMilanPlayer();
               break;  
           }//end of case Alan Milan
           default:
               System.out.println("Artist not supported.");
               return;
       }//end of switch(choice)
       
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
   }
   
    /**
    * Method: sortArtists
    * Description: Sorts the artists array alphabetically using bubble sort.
    */
   public static void sortArtists(String[] artists)
   {
       // Bubble sort implementation to sort the artists array alphabetically
       for (int i = 0; i < artists.length - 1; i++)
       {
           for (int j = 0; j < artists.length - i - 1; j++)
           {
               if (artists[j].compareToIgnoreCase(artists[j + 1]) > 0)
               {
                   // Swap artists[j] and artists[j+1]
                   String temp = artists[j];
                   artists[j] = artists[j + 1];
                   artists[j + 1] = temp;
               }
           }
       }
   }
}

