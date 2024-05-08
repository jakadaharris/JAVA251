public class Person
{
   private String personName; // Person's name
   private double heightInM; // Person's height (in meters)
   private double weightInKG; // Person's weight (in killograms)
   private BMI bmi; // BMI score
   private static int personCount = 0; // Static variable to hold record of all data of the person

   // No-arg constructor
   public Person()
   {
      this.personName = "";
      this.heightInM = 0.0;
      this.weightInKG = 0.0;
      this.bmi = new BMI();
      personCount++;
   }

   /*
     Constructor that accepts arguments for each field
       - @param n  the person's name
       - @param h  the person's height (in meters)
       - @param w  the person's weight (in kilograms)
   */
   public Person(String n, double h, double w)
   {
      this.personName = n;
      this.bmi = new BMI(h, w);
      this.heightInM = h;
      this.weightInKG = w;
   }

   // Setters
   /*
     The setName method updates the value of the personName field
        -  @param n  the person's personName
   */
   public void setName(String n)
   {
      this.personName = n;
   }

   /*
     The setHeightInMeters method updates the value of the heightInM field
        - @param h  the person's height in meters
   */
   public void setHeightInMeters(double h)
   {
      this.heightInM = h;
    }

   /*
     The setWeightInKilograms method updates the value of the weightInKG field
        - @param w  the person's weight in kilograms
   */
   public void setWeightInKilograms(double w)
   {
      this.weightInKG = w;
      this.bmi.setWeight(w);
   }

   // Getters
   // The getName method returns the value of the personName field
   public String getName()
   {
      return this.personName;
   }

   // The getHeightInMeters method returns the value of the heightInM field
   public double getHeightInMeters()
   {
      return this.heightInM;
   }

   // The getWeightInKilograms method returns the value of the weightInKG field

   public double getWeightInKilograms()
   {
      return this.weightInKG;
   }

   // The getBmiObject method returns the instance of the BMI object
   public BMI getBmiObject()
   {
      return this.bmi;
   }

   // The getPersonCount method returns the value of the personCount static field
   public static int getPersonCount()
   {
      return personCount;
   }
     
   
   // Calculate methods 
   // This method converts the person's height in meters and returns (in String format) the perosn's height in feet
   public String calcHeightFeetInches() 
   {
      int feet = (int) (this.heightInM * 39.3701 / 12);
      int inches = (int) (this.heightInM * 39.3701 % 12);
      return String.format("Height: %dft %din \n", feet, inches);
   }   

   // This method converts the peross'ns weight in kilograms and returns (in String format) the person's weight in pounds
   public String calcWeightPounds() 
   {
      double pounds = (this.weightInKG * 2.20462);
      return String.format("Weight: %.2f lbs.\n", pounds);
   }
   
   // The toString() method returns the string containing the person's info as well as the BMI aggregate toString output
   public String toString()
   {
      return "-----------------------------------------------------------------------------------------------------\n" +
            "Name: " + this.personName + "\n" +
            "Height (in m): " + this.heightInM + " meters \n" +
            "Weight (in kg): " + this.weightInKG + " kilograms \n" +
            "Height (in ft): " + calcHeightFeetInches() +
            "Weight (in lb): " + calcWeightPounds() +
            getBmiObject().toString() + 
            "\n-----------------------------------------------------------------------------------------------------\n";
   }
}// close Person class
