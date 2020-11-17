/**
 * Event.java - Every instance of this class represents an event that can hold
 * data on ticketSales, donations and expenses.  There are also methods
 * addAmount, displayTotals, and calcEventProfit available for use.
 * 
 * @author Matthew Hartigan
 * @version 1.0
 */
public class Event {
   private double ticketSales;   // total profit from event ticket sales
   private double donations;     // total profit from event donations
   private double expenses;      // total expenses to put on the event

   // Constructor definitions
   public Event () {
      ticketSales = 0;
      donations = 0;
      expenses = 0;
   }   
   
   // "Get" method definitions
   public double getTicketSales () {
      return ticketSales;
   }

   public double getDonations () {
      return donations;
   }
    
   public double getExpenses () {
      return expenses;
   }
   
   // User-defined methods
   public void addAmount(char amountType, double amountValue) {
      switch(amountType) {
         case 'T':
            ticketSales = ticketSales + amountValue;
            break;
         case 'D':
            donations = donations + amountValue;
            break;
         default:
            expenses = expenses + amountValue;
      }
   }
   
   public void displayTotals() {
      System.out.println();
      System.out.printf("Total ticket sales:%11.2f", ticketSales);
      System.out.println();
      System.out.printf("Total donations:%14.2f", donations);
      System.out.println();
      System.out.printf("Total expenses:%15.2f", expenses);
      System.out.println();
   }
   
   public double calcEventProfit() {
      return ticketSales + donations - expenses;
   }
}