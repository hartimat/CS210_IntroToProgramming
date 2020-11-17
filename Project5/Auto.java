/**
 *This class defines private fields to hold details about an automobile
 * as well as member methods to get and set each of those values
 *
 * @author Matthew Hartigan
 * @version 1.0
 */
public class Auto {
   private int modelYear = 0;   // year
   private String makeModel = "unknown";   // likely two words
   private double mileage = 0.0;   // miles per gallon
   private double tankCapacity = 0.0;   // gallons
   
   // Define Constructors
   /**
    * Default constructor for Auto class
    */  
   public Auto() {
      this.modelYear = 0;
      this.makeModel = "unknown";
      this.mileage = 0.0;
      this.tankCapacity = 0.0;
   }

   //Define "Set" Methods
   /**
    * Method to set private data field modelYear
    *
    * @param inputYear   int to set private data field modelYear to
    */  
   public void setModelYear(int inputYear) {
      this.modelYear = inputYear;
   }
   
   /**
    * Method to set private data field makeModel 
    *
    * @param inputMakeModel   String to set private data field makeModel to
    */  
   public void setMakeModel(String inputMakeModel) {
      this.makeModel = inputMakeModel;
   }
   
   /**
    * Method to set private data field mileage
    *
    * @param inputMileage   double to set private data field mileage to
    */  
   public void setMileage(double inputMileage) {
      this.mileage = inputMileage;
   }
   
   /**
    * Method to set private data field tankCapacityr
    *
    * @param inputTankCapacity   double to set private data field 
    *                                              tankCapacity to
    */  
   public void setTankCapacity(double inputTankCapacity) {
      this.tankCapacity = inputTankCapacity;
   }
   
   //Define "Get" Methods
   /**
    * Method to return private data field modelYear
    *
    * @return this.modelYear   int containing Auto object's model year
    */   
   public int getModelYear() {
      return this.modelYear;
   }
   
   /**
    * Method to return private data field makeModel
    *
    * @return this.makeModel   String containing Auto object's make & model
    */   
   public String getMakeModel() {
      return this.makeModel;
   }
   
   /**
    * Method to return private data field mileage
    *
    * @return this.mileage   double containing Auto object's mileage
    */   
   public double getMileage() {
      return this.mileage;
   }
   
   /**
    * Method to return private data field tankCapacity
    *
    * @return this.tankCapacity   double containing Auto object's tank capacity
    */   
   public double getTankCapacity() {
      return this.tankCapacity;
   }

}
