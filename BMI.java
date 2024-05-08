public class BMI {
   private double height; // Person's height in meters
   private double weight; // Person's weight in kilograms

   // No arg constructor
   public BMI() 
   {
      this.height = 0.0;
      this.weight = 0.0;
   }

   /*
     Constructor that accepts arguments for each field
         - @param h the height in meters
         - @param w the weight in kilograms
    */
   public BMI(double h, double w) 
   {
      setHeight(h);
      setWeight(w);
   }

   // Setters
   /*
      The setHeight method updates the value of the height field
         - @param h the person's height in meters
   */
   public void setHeight(double h) 
   {
      this.height = h;
   }

   /*
      The setWeight method updates the value of the weight field
         - @param w the person's weight in kilograms
   */
   public void setWeight(double w) 
   {
      this.weight = w;
   }

   // Getters 
   //The getHeight method returns the value of the height field
   public double getHeight() 
   {
      return height;
   }

   // The getWeight method returns the value of the weight field
   public double getWeight() 
   {
      return weight;
   }

   // Methods to calculate BMI and determine weight status
   //The calcBMI method calculates the BMI based on height and weight
    
   public double calcBMI() 
   {
      return (weight / (height * height));
   }

   //The weightStatus method determines the weight status based on BMI
   public String weightStatus() 
   {
      double bmi = calcBMI();
      if (bmi < 18.5) {
         return "Underweight";
      } else if (bmi < 25.0) {
         return "Healthy weight";
      } else if (bmi < 30.0) {
         return "Overweight";
      } else {
         return "Obese";
      }
   } // weightStatus

   //The toString method returns a string representation of the BMI and weight status
   public String toString() 
   {
      return String.format("BMI: %.1f \nStatus: %s", calcBMI(), weightStatus());
   }
} // Close BMI class
