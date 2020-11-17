/**
 * Class to define data fields and methods for an array of Players
 * which represents a roster for a soccer team
 * @author Matthew Hartigan
 * @version 1.0
 */

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayerArrayImpl {
   public final static int ROSTER_MAX = 11;   // size of array
    
   private Player [] playerArray;             // list of players
   private int numPlayers;                    // number of players in list
   
   
   /**
    * Constructor
    */
   public PlayerArrayImpl() {
       this.numPlayers = 0;
       playerArray = new Player[ROSTER_MAX];
   }
   
   
   /**
    * getter
    * @return numPlayers
    */
   public int getNumPlayers() {
      return numPlayers;
   }

   
   /**
     * setter
     * @param numPlayers 
     */
   public void setNumPlayers(int numPlayers) {
       this.numPlayers = numPlayers;
    }
     
   
   /**
    * Method to read player data from file specified by filename
    * Each line of the file will contain a player number and a player rating, 
    * separated by a space. Sample file lines:
    * 45 8
    * 33 6
    * The method will create a player object from each line of data, 
    * and place the object into the playerArray
    * 
    * @param filename - name of file containing player data
    * @throws IOException - to be handled by caller
    */
   public void readRosterFile(String filename) throws IOException, 
      ArrayIndexOutOfBoundsException {
      
      // Open file object and scanner to read from input file
      FileInputStream fileObject = new FileInputStream(filename);
      Scanner fileObjectScanner = new Scanner(fileObject);
      
      // Temporary variables to hold file contents
      int jerseyNumber = 0;
      int playerRating = 0;
      int i = 0;   // counter for outer loop
     
      // Read entire contents of input file
      while (fileObjectScanner.hasNext()) {
         
         // Get player's jersey number then rating from one input file line
         jerseyNumber = fileObjectScanner.nextInt();
         playerRating = fileObjectScanner.nextInt();
            
         // Create a new Player object holding the input file variables
         Player newPlayer = new Player(jerseyNumber, playerRating);
            
         // Add the new player to the playerArray
         this.playerArray[this.numPlayers] = newPlayer;
         setNumPlayers(getNumPlayers() + 1);   // Increment numPlayers
      }
      
      fileObject.close();   // Close input file
   }

   
   /**
    * Method to display player jersey numbers and player ratings 
    * for each player in playerArray
    */ 
   public void displayRoster() {
      int i = 0;  // for loop counter
      
      for (i = 0; i < this.numPlayers; ++i) {
         System.out.println("Player " + (i + 1) + " - jersey #" + 
            this.playerArray[i].getJerseyNum() + ", rating is " +
            this.playerArray[i].getRating());
      }

   }
  
   
   /**
    * Method to add a player to the playerArray, if there is room
    * 
    * @param jerseyNum - of player to add
    * @param rating - of player to add
    */
   public void addPlayer(int jerseyNum, int rating) {   
      
      if (this.numPlayers == ROSTER_MAX) {   // Check roster not full
         System.out.println("Roster is full -- cannot add more players");
      }
      else {   // Add new player to the array
         Player newPlayer = new Player(jerseyNum, rating);
         
         this.playerArray[this.numPlayers] = newPlayer;
         setNumPlayers(getNumPlayers() + 1);   // Increment numPlayers
         
         // Display new player data to screen
         System.out.println("Player " + newPlayer.getJerseyNum() + 
            " successfully added");
      }
   }
  
   
   /**
    * Method to update one player's rating
    * @param jerseyNum - of player to update
    * @param rating - player's new rating
    */
   public void updatePlayerRating(int jerseyNum, int rating) {
      int i = 0;   // counter variable
      boolean noJerseyMatch = true;   // flag for no jerseyNum match
      
      //   Search playerArray[] for matching jerseyNum
      for (i = 0; i < this.numPlayers; ++i) {
         if (jerseyNum == this.playerArray[i].getJerseyNum()) {
            this.playerArray[i].setRating(rating);
            noJerseyMatch = false;
         }
      }
      
      // Display message if no jerseyNum match is found
      if (noJerseyMatch) {
         System.out.println("Jersey number " + jerseyNum + 
            " not found -- cannot update rating");
      }
   }
    
   
   /**
    * Method to save the data from playerArray to a file    
    * (IOExceptions handled within the method)
    * Each line of the file will contain a player number and a player rating, 
    * separated by a space. Sample file lines:
    * 45 8
    * 33 6
    * 
    * @param filename - name of file to write data to
    */
   public void writeRosterFile(String filename) {
      int i = 0;
      
      try {
         // Open output file
         PrintWriter outputFileObject = new PrintWriter(filename);
         
         // Once file is open, print playerArray[] contents to it
         for (i = 0; i < this.numPlayers; ++i) {
            outputFileObject.println(this.playerArray[i].getJerseyNum() + " " 
               + this.playerArray[i].getRating());  
         }
         
         // Close the file and display message to screen
         outputFileObject.close();
         System.out.println("Roster saved to file " + filename);
      }
      catch (IOException excpt) {   // In case or error while opening file
         System.out.println("**Error: cannot create new roster file " + filename);
      }
   }   


   /**
    * getter - FOR TESTING USE ONLY -- STUDENTS SHOULD NOT CALL THIS METHOD IN THEIR PROGRAMS
    * @return array of players 
    */
    public Player[] getPlayerArray() {
        return playerArray;
    }
}
