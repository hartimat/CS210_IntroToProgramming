import java.util.Scanner;

/**
 * Program that iteratively calculates the value of Pi using the
 * arithmetic series:
 * Pi = 4 - 4/3 + 4/5 - 4/7 + ...
 * User is asked to input the number of terms in the series that they would
 * like to use to approximate Pi, as well as the frequency at which the 
 * program displays the current value of Pi as it calculates.
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */
public class PiApproximator {

   /**
    * This main method is first used to display an initial program description
    * to the user.  It subsequently makes two calls to a user defined function 
    * that requests user input, and one call to a user defined function that 
    * calculates and displays the value of Pi to the screen.
    * 
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      String numTermsPrompt = "Enter the number of terms to use:";
      String displayIntervalPrompt = "Display Pi after every how many steps?";
      int numTerms = 0;   // number of terms the user wants to approx Pi with
      int displayInterval = 0;   // how frequently user wants to display Pi to screen
      
      Scanner userInput = new Scanner(System.in);
      
      // Tell user what program does
      System.out.println("Program will approximate Pi");
      
      // Request number of terms user wants to use to approximate Pi
      numTerms = promptUserInput(numTermsPrompt, userInput);
      
      // Request how often the user wants to display calculated Pi value
      displayInterval = promptUserInput(displayIntervalPrompt, userInput);
      System.out.println();
      System.out.println("RESULTS");
      
      // Calculate and display results to screen at user designated frequency
      calcAndDisplayPi(numTerms, displayInterval);      
   }
   
   /**
    * Method promptUserInut takes in a String message, displays it to the user
    * and then reads in their input using the input Scanner object parameter,
    * userInput.  If there are no input errors, it returns the user input value to
    * the main method.
    * 
    * @param messageToUser   String message to prompt user for input
    * @param userInput   Scanner object to collect user's response to input
    *                                request
    * @return userInputValue   int representing user's input that gets returned
    *                                        to method main if there are no input errors
    */
   public static int promptUserInput(String messageToUser, Scanner userInput) {
      int userInputValue = 0;
      boolean errorInInput = false;   // flag user input errors
      
      // Prompt and evaluate user input until they provide input with no errors
      do {
         System.out.println(messageToUser);
         userInputValue = userInput.nextInt();
         if (userInputValue <= 0) {   // check userInput for errors
            errorInInput = true;
            System.out.println("Invalid input.  Must be positive and non-zero.");
         }
         else {
            errorInInput = false;   // reset flag to false in case was true in previous
                                           // iteration of loop
         }
      } while (errorInInput);
      
      return userInputValue;
   }
   
   /**
    * Method calcAndDisplayPi takes in the user's desired number of terms to
    * approximate Pi with, as well as how frequently they would like to display
    * intermittent Pi values to the screen.  The arithmetic sequence outlined in 
    * the class description above is used to calculate values of Pi.  Once 
    * complete, the final value of Pi is also displayed to the screen.
    * 
    * @param numTerms   int, number of terms the user wants to 
    *                                  approximate Pi with
    * @param displayInterval   int, how frequently the user wants to display
    *                                       intermittent values of Pi to the screen
    */
   public static void calcAndDisplayPi(int numTerms, int displayInterval) {
      double valueOfPi = 0.0;
      double nextTerm = 0.0;
      int i = 0;   // counter variable used in for loop
      
      for (i = 1; i <= numTerms; ++i) {
         nextTerm = 4.0 / ((2.0 * i) - 1.0);
         if ((i % 2) == 0) {
            valueOfPi = valueOfPi - nextTerm;
         }
         else {
            valueOfPi = valueOfPi + nextTerm;
         }
         
         // Decide if displaying or not
         if ((i % displayInterval) == 0) {
            System.out.printf("At term " + i + ": Pi = %.9f\n", valueOfPi);
         }
      }
      
      System.out.println();
      System.out.printf("Final Pi at term " + (i - 1) + " = %.9f\n", valueOfPi);
   }
   
}
