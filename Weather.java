public class Weather 
{

   private double kelvinTemperature; // Temperature (in K)
   private String skyCondition; // Current condition of sky (sunny, cloudy, rainy, snowy)

   // No-arg constructor
   public Weather() 
   {
      kelvinTemperature = 0.0;
      skyCondition = "";
   }

   /*
      Parameter k = Temperature (in K)
      Paramter s = Current condition of sky (sunny, cloudy, rainy, snowy)
   */
   public Weather(double k, String s) 
   {
      kelvinTemperature = k;
      skyCondition = s;
   }

   // Setters
   
   /* 
      setKelvinTemperature method updates value of temp (in K) field
      Parameter k = Temperature (in K)
   */ 
   public void setKelvinTemperature(double k) 
   {
      kelvinTemperature = k;
   }
   
   /* 
      setSkyCondition method updates the sky condition field
      Parameter s = Current condition of sky (sunny, cloudy, rainy, snowy)
   */ 
   public void setSkyCondition(String s) 
   {
      skyCondition = s;
   }
   
   // Getters
   
   // getKelvinTemperature method retrieves the temp (in K) field w/ no parameter
   public double getKelvinTemperature() 
   {
      return kelvinTemperature;
   }
   
   // getSkyCondition method retrieves sky condition field w/ no paramter
   public String getSkyCondition() 
   {
      return skyCondition;
   }
   
   // Other methods
   
   // calculateCelsiusTemp calculates Cel temperature w/ no parameter
   public double calculateCelsiusTemp() 
   {
      return kelvinTemperature - 273.15;
   }
   
   // calculateFahrenheitTemp method calculates Fah temperature w/ no parameter
   public double calculateFahrenheitTemp() 
   {
      return (kelvinTemperature - 273.15) * (9.0 / 5.0) + 32;
   }
   
   // toString() method displays temperature in Cel, Fah, and K
   public String toString() {
      return "High Temperature:\n" + String.format("\t %.2f C\n", calculateCelsiusTemp()) + String.format("\t %.2f F\n", calculateFahrenheitTemp()) + String.format("\t %.2f K", kelvinTemperature);   
   }
} // End class
