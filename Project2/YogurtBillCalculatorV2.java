/**
 *Original "YogurtBillCalculator.java" program description:
 * Program to calculate costs of customer's yogurt purchases at a local frozen
 *yogurt shop.  Customers purchase yogurt by the whole ounce, decide if they
 * want it in a plastic cup or waffle cone, and how many toppings to add.
 * Purchases over a certain amount of ounces are discounted.
 * 
 * New "YogurtBillCalculatorV2.java" program description:
 * Program to modify the original "YogurtBillCalculator.java" program described
 * above per owner's request.  Modifications include:
 *       1) Ice cream added to menu
 *       2) Price of yogurt adjusted
 *       3) New container options
 *       4) Price of toppings adjusted
 *       5) Discount removed (it is now built into the adjusted prices) 
 * 
 * I implemented the extra credit for this assignment.
 * See "containerIsFree" and "noToppingsChosen" boolean variables
 * 
 * Author: Matthew Hartigan
 */
import java.util.Scanner;

public class YogurtBillCalculatorV2 {

   public static void main(String[] args) {
      final double COST_YOGURT_BELOW = 0.44;  // USD per oz., below ounce threshold
      final double COST_YOGURT_ABOVE = 0.41;   // USD per oz., above ounce threshold
      final double COST_ICE_CREAM_BELOW = 0.51;   // USD per oz., below ounce threshold
      final double COST_ICE_CREAM_ABOVE = 0.47;   // USD per oz., above ounce threshold
      final double COST_TOPPINGS_BELOW_THRESHOLDS= 0.50;   // USD per oz., below lower and upper thresholds
      final double COST_TOPPINGS_BETWEEN_THRESHOLDS = 0.45;   // USD per oz., between lower and upper thresholds
      final double COST_TOPPINGS_ABOVE_THRESHOLDS= 0.40;   // USD per oz., above lower and upper thresholds
      final double COST_PLASTIC_CUP = 0.0;   // USD, currently free
      final double COST_SUGAR_CONE = 0.25;   // USD
      final double COST_WAFFLE_CONE = 0.50;  // USD
      final double COST_SOUVENEIR_BOWL = 0.75;   // USD
      final int OUNCE_THRESHOLD = 10;   // ounces
      final int TOPPINGS_THRESHOLD_LOWER = 2;   // number of toppings. Above this level, price per topping reduced
      final int TOPPINGS_THRESHOLD_UPPER = 4;   // number of toppings. Above this level, price per topping further reduced

      
      double totalTreatCost = 0.0;   // USD, "Treat" refers to ice cream or yogurt
      double totalToppingsCost = 0.0;   // USD
      double totalContainerCost = 0.0;   // USD
      double totalCost = 0.0;   // USD
      int numOuncesPurchased = 0;   // All treats are purchased in whole ounces
      int numToppings = 0;   // Default zero toppings added
      int treatType;   // Holds user input treat type preference
      char containerType;   // Holds user input container type preference
      String treatChosen = "";   // Name of treat chosen by user
      String containerName = "";   // Name of container chosen by user
      boolean containerIsFree = false;   // Container price flag
      boolean noToppingsChosen = false;   // Topping amount flag
      
      // USER INPUT
      // Greet user, request their treat preference and desired ounces
      Scanner userInput = new Scanner(System.in);
      System.out.println("Frozen Treat Bill Calculator");
      System.out.println();
      System.out.println("Enter 1 for frozen yogurt or 2 for ice cream:");
      treatType = userInput.nextInt();
      if (treatType == 1) {
         treatChosen = "frozen yogurt";
         System.out.printf("Enter %s weight (whole ounces):\n", treatChosen);
         numOuncesPurchased = userInput.nextInt();
      }
      else if (treatType == 2) {
         treatChosen = "ice cream";
         System.out.printf("Enter %s weight (whole ounces):\n", treatChosen);
         numOuncesPurchased = userInput.nextInt();
      }
      
      // Request number of toppings
      System.out.println("How many toppings?");
      numToppings = userInput.nextInt();
      noToppingsChosen = (numToppings < 1) ? true : false;   // Flag if no toppings
      
      // Request container preference
      System.out.println("Container options are");
      System.out.println("  C - plastic cup");
      System.out.println("  S - sugar cone");
      System.out.println("  W - waffle cone");
      System.out.println("  B - souvenir bowl");
      System.out.println("Enter choice:");
      containerType = userInput.next().charAt(0);
      switch (containerType) {
         case 'c':
         case 'C': {
            containerName = "plastic cup";
            totalContainerCost = COST_PLASTIC_CUP;
            break;
         }
         case 's':
         case 'S': {
            containerName = "sugar cone";
            totalContainerCost = COST_SUGAR_CONE;
            break;
         }
         case 'w':
         case 'W': {
            containerName = "waffle cone";
            totalContainerCost = COST_WAFFLE_CONE;
            break;
         }     
         case 'b':
         case 'B': {
            containerName = "souvenir bowl";
            totalContainerCost = COST_SOUVENEIR_BOWL;
            break;
         }         
         default: {
            System.out.println("Invalid choice - plastic cup will be used");
            containerName = "plastic cup";
            totalContainerCost = COST_PLASTIC_CUP;
         }
      }
      containerIsFree = (totalContainerCost == COST_PLASTIC_CUP) ? true : false;   // Flag if free container
      System.out.println();
      System.out.println();
      
      // DISPLAY ORDER SUMMARY
      System.out.println("ORDER");
      System.out.printf("Treat type:%19s\n", treatChosen);
      System.out.printf("Weight (oz):%18d\n", numOuncesPurchased);
      System.out.printf("Container:%20s\n", containerName);
      System.out.printf("Number Toppings:%14d\n", numToppings);
      System.out.println();
      
      // CALCULATE BILL
      // Treat cost
      if (treatType == 1) {
         if (numOuncesPurchased < OUNCE_THRESHOLD) {
            totalTreatCost = COST_YOGURT_BELOW * numOuncesPurchased;
         }
         else {
            totalTreatCost = COST_YOGURT_ABOVE * numOuncesPurchased;
         }
      }
      else if (treatType == 2) {
         if (numOuncesPurchased < OUNCE_THRESHOLD) {
         totalTreatCost = COST_ICE_CREAM_BELOW * numOuncesPurchased;
         }
         else {
            totalTreatCost = COST_ICE_CREAM_ABOVE * numOuncesPurchased;
         }
      }
      totalCost += totalTreatCost;
      
      // Topping cost
      if (numToppings <= TOPPINGS_THRESHOLD_LOWER) {
         totalToppingsCost = COST_TOPPINGS_BELOW_THRESHOLDS * numToppings;         
      }
      else if (numToppings <= TOPPINGS_THRESHOLD_UPPER) {
         totalToppingsCost = COST_TOPPINGS_BETWEEN_THRESHOLDS * numToppings;            
      }
      else {
         totalToppingsCost = COST_TOPPINGS_ABOVE_THRESHOLDS * numToppings;   
      }
      totalCost += totalToppingsCost;
      
      // Container cost was calculated directly after user input container preference for efficiency
      totalCost += totalContainerCost;
     
      // DISPLAY BILL SUMMARY
      System.out.println("BILL");
      System.out.printf("Treat cost:%19.2f\n", totalTreatCost);
      if (containerIsFree && noToppingsChosen) {
         // Do not output container cost, topping cost, dividing line or total cost
      }
      else if (containerIsFree){
         System.out.printf("Topping Cost:%17.2f\n", totalToppingsCost);
         System.out.printf("%30s\n", "-------");
         System.out.printf("Total%25.2f\n", totalCost);
      }
      else if (noToppingsChosen) {
         System.out.printf("Container Cost:%15.2f\n", totalContainerCost);
         System.out.printf("%30s\n", "-------");
         System.out.printf("Total%25.2f\n", totalCost);
      }
      else {
         System.out.printf("Container Cost:%15.2f\n", totalContainerCost);
         System.out.printf("Topping Cost:%17.2f\n", totalToppingsCost);
         System.out.printf("%30s\n", "-------");
         System.out.printf("Total%25.2f\n", totalCost);
      }

   }

   
}
