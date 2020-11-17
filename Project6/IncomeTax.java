import java.util.Scanner;

public class IncomeTax {    
   // Method to get a value from one table based on a range in the other table
   public static double getCorrespondingTableValue(int search, int [] baseTable, double [] valueTable) {
      int baseTableLength;
      double value;
      int i;
      boolean keepLooking;

      baseTableLength = baseTable.length;
      value = 0.0;
      i = 0;
      keepLooking = true;

      while ((i < baseTableLength) && keepLooking) {
         if (search <= baseTable[i]) {
            value = valueTable[i];
            keepLooking = false;
         }
         else {
            ++i;
         }
      }

      return value;
   }
   
   // Method to take annual salary input
   public static int getAnnualSalaryInput (Scanner scnr) {
      int annualSalary = 0;
      System.out.println("\nEnter annual salary (0 to exit): ");
      annualSalary = scnr.nextInt();
      return annualSalary;
   }
 
   public static void main (String [] args) { 
      Scanner scnr = new Scanner(System.in);
      int annualSalary;
      double taxRate;
      int taxToPay;
      int i;

      int [] salaryBase = { 20000,     50000,     100000,     999999999 };
      double [] taxBase = {   .10,       .20,        .30,           .40 };
    
      // FIXME: Change the input to come from a method
      annualSalary = getAnnualSalaryInput(scnr);

      while (annualSalary > 0) {
         taxRate = getCorrespondingTableValue(annualSalary, salaryBase,  taxBase);

         taxToPay= (int)(annualSalary * taxRate);  // Truncate tax to an integer amount
         System.out.println("Annual salary: " + annualSalary + 
                            "\tTax rate: " + taxRate +
                            "\tTax to pay: " + taxToPay);

         // Get the next annual salary
         // FIXME: Change the input to come from a method
         annualSalary = getAnnualSalaryInput(scnr);
      }
   }
}
