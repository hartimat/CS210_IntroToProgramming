import java.util.Scanner;

/**
 *This program defines the AutoManager class.  The AutoManager class 
 * contains methods main and readAutoData.  The main method instantiates
 * a Scanner and a user defined Auto object.  It then calls readAutoData
 * to collect user input to define the fields of the created Auto object.  Finally,  
 * it displays a summary to screen.
 *
 * @author Matthew Hartigan
 * @version 1.0
 */
public class AutoManager {

   /**
    * A simple method to instantiate a Scanner object and user defined Auto
    * object.  Once both of these objects are defined, they are passed to 
    * member method readAutoData.  Then a summary of user input is
    * displayed to screen based on what was read by readAutoData.
    *
    */
   public static void main(String[] args) {
      Auto userCar = new Auto();
      Scanner userInput = new Scanner(System.in);

      readAutoData(userInput, userCar);
      
      // Output summary of user input auto data to screen
      System.out.println();
      System.out.printf("%d %s has a %.1f gallon tank and gets %.1f miles per "
      + "gallon\n", userCar.getModelYear(), userCar.getMakeModel(), 
      userCar.getTankCapacity(), userCar.getMileage());
   }
   
   /**
    * A method that takes two input parameters: a Scanner object to read user
    * input and a user defined Auto object to hold user input auto data.  It then
    * prompts the user for several auto data fields and sets them in the 
    * Auto object.
    *
    * @param userInput   Scanner object to collect user input
    * @param userCar   Auto object to hold user input
    */   
   public static void readAutoData(Scanner userInput, Auto userCar) {
      // Prompt user for input and set Auto object data fields accordlingly
      System.out.println("Enter auto model year:");
      userCar.setModelYear(userInput.nextInt());
      userInput.nextLine();
      
      System.out.println("Enter auto make and model:");
      userCar.setMakeModel(userInput.nextLine());
      
      System.out.println("Enter auto mileage (in miles per gallon):");
      userCar.setMileage(userInput.nextDouble());
      userInput.nextLine();
      
      System.out.println("Enter auto tank capacity (in gallons):");
      userCar.setTankCapacity(userInput.nextDouble());      
   }

}
