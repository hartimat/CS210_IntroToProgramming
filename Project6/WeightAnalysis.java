/** 
 * Description
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */

import java.util.Scanner;

public class WeightAnalysis {
   public static void main(String[] args) {
      int weightCount = 0;
      int i = 0;
      double totalWeight = 0.0;
      double [] weightsToAnalyze = null;
      
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Number of weights to analyze:");
      weightCount = keyboard.nextInt();
      
      /* Add main method code here. */
      weightsToAnalyze = new double[weightCount];
      
      for (i = 0; i < weightCount; ++i) {
         System.out.println("Enter weight " + (i + 1) + ":");
         weightsToAnalyze[i] = keyboard.nextDouble();
      }
      
      System.out.println();
      System.out.print("You entered weights: ");
      for (i = 0; i < weightCount; ++i) {
         totalWeight = totalWeight + weightsToAnalyze[i];
         System.out.printf("%.1f ", weightsToAnalyze[i]);
      }
      System.out.println();
      System.out.println();
      System.out.printf("Total weight:%11.2f", totalWeight);
      System.out.println();
      System.out.printf("Average weight:%9.2f", totalWeight / weightCount);
      System.out.println();
      System.out.printf("Max weight:%13.2f", getMaxWeight(weightsToAnalyze));
      System.out.println();
      
      return;
   }
   
   public static double getMaxWeight(double [] inputArray) {
      int index = 0;
      double maxElement = inputArray[index];
      
      for (index = 0; index < inputArray.length; ++index) {
         if (inputArray[index] > maxElement) {
            maxElement = inputArray[index];
         }
      }
      return maxElement;
   }

}
