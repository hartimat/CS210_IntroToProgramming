import java.util.Scanner;

/**
 * Program that takes user input describing the details of their monthly
 * cell phone plan. Plan details are then summarized and displayed on 
 * screen.  Charges for the month (including and data usage overages) 
 * are calculated, totaled, then displayed to the screen as well. 
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */
public class CellPhoneBillGenerator {

   /**
    * This main() method is used to interface with the user, collecting their
    * input on the details of their monthly cell phone plan. Once the data 
    * is collected, main() calls displayPlanAndUsageSummary(), 
    * calcPlanRate(), calcDataOverageCharges(), and displayCharges() to
    * process the user input.
    *
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      char planType;   // holds user input
      double dataUsedThisMonth = 0.0;   // GB, holds user input
      double planRate = 0.0;   // USD
      double dataOverageCharge = 0.0;   // USD
      int numberOfLines = 1;   // holds user input, default is single line plan
      
      // Display program description for user
      System.out.println("Cell Phone Bill Generator");
      System.out.println();
      
      // Get user input on plan type, data used this month
      Scanner scnr = new Scanner(System.in);
      System.out.println("Available plans:");
      System.out.println("    S - single line plan");
      System.out.println("    F - family plan");
      System.out.println("Enter plan type:");
      planType = scnr.next().charAt(0);
      System.out.println("Enter data used this month (in GB):");
      dataUsedThisMonth = scnr.nextDouble();
      
      // If it's a family plan, get user input on total number of lines
      if (planType == 'F' || planType == 'f') {
         System.out.println("Enter number of lines on family plan:");
         numberOfLines = scnr.nextInt();
         // adjust number of lines to 2 if user input value too low
         if (numberOfLines <= 1) {   
            numberOfLines = 2;
         }
      }

      // Call methods to calculate and display plan, usage summary and
      // charges to user
      displayPlanAndUsageSummary(numberOfLines, dataUsedThisMonth);
      planRate = calcPlanRate(numberOfLines);
      dataOverageCharge = calcDataOverageCharges(numberOfLines, dataUsedThisMonth);
      displayCharges(planRate, dataOverageCharge);
   }
   
   /**
    * Method takes in the number of lines and data usage for the user's monthly
    * plan, then displays a formatted summary of this information to the screen.
    *
    * @param numberOfLines    - int representing the user input number of phone 
    * lines in their monthly plan
    * @param dataUsedThisMonth      - double representing the user input 
    * amount of data they used this month (GB)
    */   
   public static void displayPlanAndUsageSummary(int numberOfLines, double dataUsedThisMonth) {
      System.out.println();
      System.out.println();
      System.out.println("PLAN/USAGE SUMMARY");
      if (numberOfLines ==1) {
         System.out.printf("Plan:%25s\n", "single");
      }
      else {
         System.out.printf("Plan:%25s\n", "family");
      }
      System.out.printf("Number of lines:%14d\n", numberOfLines);
      System.out.printf("Data usage:%16.1f GB\n", dataUsedThisMonth);
      return;
   }
   
   /**
    * Method takes in the user input number of phone lines in their monthly 
    * plan and uses it to calculated the monthly plan rate based on the 
    * given rate schedule from the program requirements description.  Rates 
    * vary for single and family plans, with additional lines costing 
    * progressively less.
    *
    * @param numberOfLines    - int representing the user input number of phone
    * lines in their monthly plan
    * @return planRate     - double representing the value of the monthly plan rate
    * that was calculated (USD)
    */   
   public static double calcPlanRate(int numberOfLines) {
      final double RATE_SINGLE_LINE = 29.99;   // USD
      final double RATE_FAMILY_TWO_LINES = 49.99;   // USD, includes both lines
      final double RATE_FAMILY_THREE_LINES = RATE_FAMILY_TWO_LINES + 22.00;   
      // USD, price includes all three lines
      final double RATE_FAMILY_PER_LINE_OVER_THREE = 12.00;   
      // USD, this rate to be added for each line over three
      
      double planRate = 0.0;
      
      // Determine plan rate based on input number of lines parameter
      if (numberOfLines == 1) {
         planRate = RATE_SINGLE_LINE;
      }
      else if (numberOfLines == 2) {
         planRate = RATE_FAMILY_TWO_LINES;
      }
      else if (numberOfLines == 3) {
         planRate = RATE_FAMILY_THREE_LINES;
      }
      else {
         planRate = RATE_FAMILY_THREE_LINES + RATE_FAMILY_PER_LINE_OVER_THREE * (numberOfLines - 3);
      }
      return planRate;
   }
   
   /**
    * Method takes in the user in put number of phone lines and data used this 
    * month and uses it to identify and calculate any applicable data use 
    * overage charges.  Returns the amount of overage charges in USD 
    * ($0.00 if no charges apply).
    *
    * @param numberOfLines    - int representing the user input number of phone
    * lines in their monthly plan
    * @param dataUsedThisMonth      - double representing the user input 
    * amount of data they used this month (GB)
    * @return dataOverageCharge     - double representing the amount charged to
    * the user for going over their monthly data allotment (USD)
    */   
   public static double calcDataOverageCharges(int numberOfLines, double dataUsedThisMonth) {
      final double DATA_OVERAGE_CHARGE = 8.49;   // USD, per GB over allotment
      final double DATA_ALLOWED_PER_LINE = 2.0;   // GB
      
      double allowedDataAmount = 0.0;   // GB
      double dataOverageCharge = 0.0;   // GB
            
      allowedDataAmount = DATA_ALLOWED_PER_LINE * numberOfLines;
      if ((Math.ceil(dataUsedThisMonth) - allowedDataAmount) > 0) {
         dataOverageCharge = (Math.ceil(dataUsedThisMonth) - allowedDataAmount) * DATA_OVERAGE_CHARGE;
      }
      return dataOverageCharge;
   }

   /**
    * Method takes in the previously calculated monthly plan rate and data 
    * overage charges.  It then displays a formatted summary of the charges
    * to the screen.  
    *
    * @param planRate      - double representing the previously calculated 
    * monthly charge for the user's phone plan (USD)
    * @param dataOverageCharge      - double representing the previously
    * calculated charge for using more than the monthly alloted data (USD)
    */   
   public static void displayCharges(double planRate, double dataOverageCharge) {
      System.out.println();
      System.out.println("CHARGES");
      System.out.printf("Plan rate%21.2f\n", planRate);
      System.out.printf("Data overage charges%10.2f\n", dataOverageCharge);
      System.out.printf("%30s\n", "-------");
      System.out.printf("Total bill%20.2f\n", planRate + dataOverageCharge);
   }

}
