/**
 * -------------------------------------------------------
 * [Class description here]
 * -------------------------------------------------------
 * Author: Zaynab Khan
 * ID: 169084511
 * Email: khan4511@mylaurier.ca
 * Date: May 1, 2026
 * -------------------------------------------------------
 */
package finalproject;
import java.util.Random;
import javax.swing.JOptionPane;

public class Recommender {
    private static String[] genres = {"Kpop", "Classic", "Pop", "Rap"};
    private static String[] songs = {
        "Seven by Jungkook", 
        "Blinding Lights by The Weeknd", 
        "God's Plan by Drake", 
        "Night Changes by One Direction"
    };

    public static void getRecommendation() {
        Random rand = new Random();
        int index = rand.nextInt(songs.length);
        
        String message = "🤖 AI Recommendation for you:\n\n" +
                         "Based on your profile, you might like:\n" +
                         "🎵 " + songs[index] + "\n\n" +
                         "Genre: " + genres[index];
                         
        JOptionPane.showMessageDialog(null, message, "AI Recommender", JOptionPane.INFORMATION_MESSAGE);
    }
}
