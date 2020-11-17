/**
 * EventManager.java - Program that reads in ticket sale, donation, and
 * expense data from a user-specified  input file.  It then preforms several 
 * calculations using this data and displays a summary to screen.
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */
import java.util.Scanner;
import java.io.*;

public class EventManager {

   public static void main(String[] args) {
      
      Scanner keyboard = new Scanner(System.in); // for user-input
      Scanner eventFile = null;   // to process input file
      FileInputStream fileByteStream = null; 
      String filename;
      Event firstEvent = new Event();
      String amountType = "";   // holds amount type key from input file
      double amountValue = 0.0;   // holds input amount value from input file

      // Get filename from user
      System.out.println("Enter filename:");
      filename = keyboard.next();
      
      try {
         // Open input file
         fileByteStream = new FileInputStream(filename);
         eventFile = new Scanner(fileByteStream);

         // Read all data from input file, increment amounts accordingly and 
         // display a summary to screen
         while(eventFile.hasNext()) {
            amountType = eventFile.next();
            amountValue = eventFile.nextDouble();
            firstEvent.addAmount(amountType.charAt(0), amountValue);

            // Display a summary to screen
            System.out.printf("Line read: %s ", amountType);
            System.out.printf("%.2f", amountValue);
            System.out.println();
         }

         // Summarize the data further and display to screen
         System.out.println("Done reading file " + filename);
         firstEvent.displayTotals();
         System.out.println();
         if (firstEvent.calcEventProfit() > 0) {
            System.out.printf("Event generated a profit of $ %.2f", firstEvent.calcEventProfit());
            System.out.println();
         }
         else {
            System.out.printf("Event generated a loss of $ %.2f", firstEvent.calcEventProfit());
            System.out.println();
         }
      }
      catch (IOException excpt) {
         System.out.println("Could not open input file " + filename + ". Program exiting.");
         return;
      }      
      
      
      // Close the input file
      try {
         fileByteStream.close(); 
      }
      catch (IOException excpt) {
         System.out.println("Could not close input file " + filename + ". Program exiting.");
         return;
      }
   }     
}      