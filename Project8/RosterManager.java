/**
 * Program to manage a soccer team roster of up to 11 players
 * Roster data will be read from a file and stored
 * User will be able to display the roster, add a player, 
 * update a player rating, and re-save the roster data.
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */

import java.io.IOException;
import java.util.Scanner;

public class RosterManager {

   /**
    * Main method to open files ,interface with user, instantiate the array 
    * containing player objects and make function calls to modify the roster
    * based on user input.
    * 
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      PlayerArrayImpl roster = new PlayerArrayImpl();
      char userChoice = '?';   // holds user input menu choice from keyboard
      int jerseyNum = 0;
      int playerRating = 0;
      String outputFilename = "";		
      String inputFilename = "";
      
      System.out.println("Enter input data filename:");
      inputFilename = keyboard.next();
      
      // Attempt to open input file and display numPlayers it contains
      try {
         roster.readRosterFile(inputFilename);
         System.out.println(roster.getNumPlayers() + " players stored");
      }

      // Handle errors opening the input file
      catch (IOException excpt1) {
         System.out.println("**Error reading input file " + inputFilename);
         System.out.println("**Program exiting");
         System.exit(99);
      }
      
      // Handle attempts to improperly access playerArray (i.e. adding a player
      // to an already full roster)
      catch (ArrayIndexOutOfBoundsException excpt2) {
         System.out.println("**Too many players in file");
         System.out.println("**Program will only use the first " + 
            PlayerArrayImpl.ROSTER_MAX + " players");
      }

      // Display menu to screen to collect user input, repeat until user quits
      do {
         userChoice = getChoice(keyboard);
         
         switch (userChoice) {
            case 'D':   // User wants to display roster to screen
               roster.displayRoster();
               break;
               
            case 'A':   // User wants to add a player to the roster
               System.out.println("Enter jersey number of player to add:");
               jerseyNum = keyboard.nextInt();   // Get jersey from user
               System.out.println("Enter rating of player:");
               playerRating = keyboard.nextInt();   // Get rating from user
               
               roster.addPlayer(jerseyNum, playerRating);
               
               break;
               
            case 'U':   // User wants to update playerRating for a specific player
               System.out.println("Enter jersey number of player to update:");
               jerseyNum = keyboard.nextInt();   // Get jersey from user
               System.out.println("Enter new rating of player:");
               playerRating = keyboard.nextInt();   // Get new rating from user
               
               // Call instance method to update rating
               roster.updatePlayerRating(jerseyNum, playerRating);
               
               break;
               
            case 'S':   // User wants to save roster to output file
               outputFilename = inputFilename.substring(0, 
                  inputFilename.indexOf('.'));   // Extract current file name
               outputFilename = outputFilename + "v2.txt";
               roster.writeRosterFile(outputFilename);   // Update to v2
               
               break;
               
            case 'E':   // User wants to exit, next loop condition check will terminate
               break;
               
            default:   // Handle invalid user input
               System.out.println("Error -- invalid menu choice");
               break;               
         }
      }
      while (userChoice != 'E');
   }
   
   
   /**
    * Method displays menu to user
    * Reads, uppercases, and returns choice from menu
    * 
    * @param keyboard - Scanner to read user data from
    * @return choice - uppercased menu choice entered by user
    */
   public static char getChoice(Scanner keyboard) {
      char choice = '?';
      
      // Display menu to screen
      System.out.println("");
      System.out.println("MENU");
      System.out.println("  D - Display Roster");
      System.out.println("  A - Add a Player");
      System.out.println("  U - Update a Player's Rating");
      System.out.println("  S - Save Roster");
      System.out.println("  E - Exit program");
      System.out.println("Enter choice:");
      
      // Collect user input char from keyboard, then return upper case char
      choice = keyboard.next().charAt(0);
      choice = Character.toUpperCase(choice);
      
      return choice;
   } 
}
