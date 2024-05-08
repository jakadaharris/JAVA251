import java.util.ArrayList;
import java.util.Scanner;

public class Demo{
   public static void main(String[] args){
      
      // Declaring variables
      ArrayList<Weather> weatherReport = new ArrayList<Weather>();
      Scanner scanner = new Scanner(System.in);
      int totalDays = 1;
      int averageDays = 1;
      String inputCondition = "";
      String skyCondition = "";
      double minTemp = 0.0;
      double maxTemp = 0.0;
      double kelvinTemp = 0.0;
      double totalCelsius = 0.0;
      double totalFahrenheit = 0.0;
      double totalKelvin = 0.0;
      double averageCelsius = 0.0;
      double averageFahrenheit = 0.0;
      double averageKelvin = 0.0;
   
      // Ask the user for the number of days in the weather report
      System.out.print("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
   
      // Input validation
      while (!scanner.hasNextInt()){
         System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
         System.out.println("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
         scanner.next();
      }
      
      totalDays = scanner.nextInt();
      
      while (totalDays < 1 || totalDays > 7){
         System.out.println("ERROR: INVALID NUMBER OF DAYS ENTERED. TRY AGAIN.");
         System.out.println("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
         while (!scanner.hasNextInt()){
            System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
            System.out.println("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
            scanner.next();
         }
         totalDays = scanner.nextInt();
         }
                  
      // Input for each day's weather
      for (int i = 1; i <= totalDays; i++) {
         System.out.println("Enter the weather conditions for day " + i + ":");
         System.out.println("\t A. Sunny");
         System.out.println("\t B. Cloudy");
         System.out.println("\t C. Rainy");
         System.out.println("\t D. Snowy");
         System.out.print("Enter your choice (A, B, C, or D)");
         
         // Input validation
         while (!scanner.hasNextLine()){
            System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
            System.out.println("Enter the weather conditions for day " + i + ":");
            System.out.println("\t A. Sunny");
            System.out.println("\t B. Cloudy");
            System.out.println("\t C. Rainy");
            System.out.println("\t D. Snowy");
            System.out.print("Enter your choice (A, B, C, or D)");
            scanner.next();
         }
         inputCondition = scanner.nextLine();
         
         while (!inputCondition.equalsIgnoreCase("A") && !inputCondition.equalsIgnoreCase("B") && !inputCondition.equalsIgnoreCase("C") && !inputCondition.equalsIgnoreCase("D")){
            System.out.println("ERROR: INVALID CHOICE. Please try again.");
            System.out.println("Enter the weather conditions for day " + i + ":");
            System.out.println("\t A. Sunny");
            System.out.println("\t B. Cloudy");
            System.out.println("\t C. Rainy");
            System.out.println("\t D. Snowy");
            System.out.print("Enter your choice (A, B, C, or D)");
            while (!scanner.hasNextLine()){
               System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
               System.out.println("Enter the weather conditions for day " + i + ":");
               System.out.println("\t A. Sunny");
               System.out.println("\t B. Cloudy");
               System.out.println("\t C. Rainy");
               System.out.println("\t D. Snowy");
               System.out.print("Enter your choice (A, B, C, or D)");
               scanner.next();
            }
         inputCondition = scanner.nextLine();
         }
         
         /* 
            Translate sky condition
            inputCondition -> skyCondition
         */
         if (inputCondition.equalsIgnoreCase("A")){
            skyCondition = "Sunny";
         } else if (inputCondition.equalsIgnoreCase("B")){
            skyCondition = "Cloudy";
         } else if (inputCondition.equalsIgnoreCase("C")){
            skyCondition = "Rainy";
         } else if (inputCondition.equalsIgnoreCase("D")){
            skyCondition = "Snowy";
         }
      
         // Declare min and max temps depending on weather condition
         if (skyCondition.equals("Snowy")) {
            minTemp = 252.59;
            maxTemp = 273.15;
         } else {
            minTemp = 273.15;
            maxTemp = 313.71;
         }
         
         // Ask user to input high temp for the day i 
         System.out.print("Enter the high kelvin temperature for day" + i + " (min: " + minTemp + ", max: " + maxTemp +"):");
      
         // Validate temperature input
         while (!scanner.hasNextDouble()){
            System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
            System.out.println("Enter the high kelvin temperature for day" + i + " (min: " + minTemp + ", max: " + maxTemp +"):");
            scanner.next();
          }
      
          kelvinTemp = scanner.nextDouble();
      
         while (kelvinTemp < minTemp || kelvinTemp > maxTemp){
            System.out.println("ERROR: INVALID HIGH TEMPERATURE ENTERED. Please try again.");
            System.out.println("Enter the high kelvin temperature for day" + i + " (min: " + minTemp + ", max: " + maxTemp +"):");
            while (!scanner.hasNextDouble()){
               System.out.println("ERROR: INVALID INPUT. TRY AGAIN.");
               System.out.println("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
               scanner.next();
         }
         kelvinTemp = scanner.nextDouble();
         }
      
         // Create Weather object and add to list
         Weather w = new Weather(kelvinTemp, skyCondition);
         weatherReport.add(w);
         
      } // End for loop
   
      // Display weather information for each day
      System.out.println("\nWeather Report:");
      for (int i = 0; i < weatherReport.size(); i++) {
         System.out.println("Day " + (i + 1) + ":");
         System.out.println(" --------------------------");
         System.out.println("Daily Weather Conditions");
         System.out.println(weatherReport.get(i));
         System.out.println(" --------------------------");
      }
   
      // Calculate total tempuraturs
      for (int i = 0; i < weatherReport.size(); i++) {
         totalCelsius += weatherReport.get(i).calculateCelsiusTemp();
         totalFahrenheit += weatherReport.get(i).calculateFahrenheitTemp();
         totalKelvin += weatherReport.get(i).getKelvinTemperature();
      }
   
      // Claculate average temperatures 
      averageCelsius = totalCelsius / totalDays;
      averageFahrenheit = totalFahrenheit / totalDays;
      averageKelvin = totalKelvin / totalDays;
   
      System.out.println("\nAverage Temperatures:");
      System.out.printf("Celsius: %.2f C\n", averageCelsius);
      System.out.printf("Fahrenheit: %.2f F\n", averageFahrenheit);
      System.out.printf("Kelvin: %.2f K\n", averageKelvin);
   
   } // End method
} // End class
 
   
     
