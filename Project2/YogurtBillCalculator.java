/**
 *Program to calculate costs of customer's yogurt purchases at a local frozen
 *yogurt shop.  Customers purchase yogurt by the whole ounce, decide if they
 * want it in a plastic cup or waffle cone, and how many toppings to add.
 * Purchases over a certain amount of ounces are discounted.
 * 
 * Author: Matthew Hartigan
 */
import java.util.Scanner;

public class YogurtBillCalculator {

   public static void main(String[] args) {
      final double COST_YOGURT_PER_OUNCE = 0.44;  // USD
      final double COST_PLASTIC_CUP = 0.0;   // USD, currently free
      final double COST_WAFFLE_CONE = 0.61;  // USD
      final double COST_PER_TOPPING = 0.53;   // USD
      final double DISCOUNT_RATE = 0.05;  // USD
      final int DISCOUNT_LIMIT = 10;   // ounces
      
      double totalYogurtCost = 0.0;   // USD
      double totalContainerCost = 0.0;   // USD
      double totalToppingsCost = 0.0;   // USD
      double totalCost = 0.0;   // USD
      double totalDiscount = 0.0;   // USD
      int numOuncesPurchased = 0;   // All yogurt purchased in whole ounces
      int numToppings = 0;   // Default zero toppings added
      int cupOrCone;   // Holds '1' if user wants plastic cup, '2' if waffle cone
      String containerName = "";   // Assigned "cup" or "cone" based on user input
      char addToppings;   // Holds 'Y' of 'y' if user wants toppings 
                                    // Holds 'N' or 'n' if no
      
      // Get user input for ounces yogurt purchased and if they want toppings
      Scanner userInput = new Scanner(System.in);
      System.out.println("Yogurt Bill Calculator");
      System.out.println();
      System.out.println("Enter yogurt weight (whole ounces):");
      numOuncesPurchased = userInput.nextInt();
      System.out.println("Do you want toppings (Y or N)?");
      addToppings = userInput.next().charAt(0);
      
      // Get user input for number of toppings if applicable
      if ((addToppings == 'Y') || (addToppings == 'y')) {
         System.out.println("How many toppings?");
         numToppings = userInput.nextInt();
      }
      else if ((addToppings == 'N') || (addToppings == 'n')) {
         numToppings = 0;
      }
      else {
         System.out.println("There was an error in the user input");
      }
      
      // Get user input on what container type they want (cup or waffle cone)
      System.out.println("Enter 1 for a plastic cup or 2 for a waffle cone:");
      cupOrCone = userInput.nextInt();
      if (cupOrCone == 1) {
         containerName = "cup";
         totalContainerCost = COST_PLASTIC_CUP;
         totalCost += totalContainerCost;
      }
      else if (cupOrCone == 2) {
         containerName = "cone";
         totalContainerCost = COST_WAFFLE_CONE;
         totalCost += totalContainerCost;
      }
      System.out.println();
      System.out.println();
      
      // Display order summary
      System.out.println("YOGURT ORDER");
      System.out.printf("Weight (oz):%13d\n", numOuncesPurchased);
      System.out.printf("Container:%15s\n", containerName);
      System.out.printf("Number Toppings:%9d\n", numToppings);
      System.out.println();
      
      // Calculate bill
      totalYogurtCost = numOuncesPurchased * COST_YOGURT_PER_OUNCE;
      totalToppingsCost = numToppings * COST_PER_TOPPING;
      totalCost += (totalYogurtCost + totalToppingsCost);
      
      // Display bill summary
      System.out.println("YOGURT BILL");
      System.out.printf("Yogurt Cost:%13.2f\n", totalYogurtCost);
      if (cupOrCone == 1) {
         // do not output plastic cup cost (it's free!)
      }
      else if (cupOrCone == 2) {
         System.out.printf("Cone cost:%15.2f\n", totalContainerCost);
      }
      System.out.printf("Topping cost:     +%6.2f\n", totalToppingsCost);
      System.out.printf("%25s\n", "-------");
      System.out.printf("%25.2f\n", totalCost);
      
      // Apply discount if applicable
      if (numOuncesPurchased >= DISCOUNT_LIMIT) {
         totalDiscount = totalCost * DISCOUNT_RATE;   // revise bill
         totalCost = totalCost - totalDiscount;
         System.out.printf("Discount:         -%6.2f\n", totalDiscount);
         System.out.printf("%25s\n", "-------");
         System.out.printf("%25.2f\n", totalCost);
      }
      else {
         // discount does not apply, take no action
      }
           
   }

   
}
