import java.util.ArrayList;
import java.util.Scanner;

public class DemoHarris {
   public static void main(String[] args) {
      // Scanner 
      Scanner scanner = new Scanner(System.in);
      
      // ArrayList
      ArrayList<Person> participants = new ArrayList<>();
      
      // Initailize variables for outputs and calculations
      double averageBMI = 0.0;
      int underweightCount = 0;
      int healthyWeightCount = 0;
      int overweightCount = 0;
      int obeseCount = 0;
      String repeat = "";
      
      do {
         // Get person's name
         System.out.print("Enter a person's name: ");
         String name = scanner.nextLine();
         while (name.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Please enter a name: ");
            name = scanner.nextLine();
         }
         
         // Get height
         double height = 0.0;
         while (true) {
            System.out.print("Enter height in total meters (min: 1.016 meters - max 2.413 meters): ");
            while (!scanner.hasNextDouble()){
               System.out.println("Invalid input. Please try again.");
               scanner.next();
            }
            height = scanner.nextDouble();
            if (height >= 1.016 && height <= 2.413) 
               break;
            System.out.println("Invalid height, please try again!");
         }
         
         // Get weight
         double weight = 0.0;
         while (true) {
            System.out.print("Enter weight in kilograms (min: 34.0194kg - max: 362.874kg): ");
            while (!scanner.hasNextDouble()){
               System.out.println("Invalid input. Please try again.");
               scanner.next();
            }
            weight = scanner.nextDouble();
            if (weight >= 34.0194 && weight <= 362.874) 
               break;
            System.out.println("Invalid weight, please try again!");
         }
         
         // Create person object and add to participants list
         Person p = new Person(name, height, weight);
         participants.add(p);
         
         // Calculate BMI
         BMI bmiCalculator = new BMI(height, weight);
         double bmi = bmiCalculator.calcBMI();
         
         // Update counts based on weight status
         String weightStatus = bmiCalculator.weightStatus();
         if (weightStatus.equals("Underweight")) {
            underweightCount++;
         } else if (weightStatus.equals("Healthy weight")) {
            healthyWeightCount++;
         } else if (weightStatus.equals("Overweight")) {
            overweightCount++;
         } else if (weightStatus.equals("Obese")) {
            obeseCount++;
         }
         
         // Update average BMI
         averageBMI += bmi;
         
         scanner.nextLine();
         
         //Ask the user if they want to continue 
         System.out.print("\nDo you wish to enter information for another person (Yes/Y/Continue/No/N/Quit)? ");
         repeat = scanner.nextLine();
         
         //Input validation
         while (!repeat.equalsIgnoreCase("Continue") && !repeat.equalsIgnoreCase("Quit") && !repeat.equalsIgnoreCase("y") && !repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("Yes") && ! repeat.equalsIgnoreCase("No")) {
            System.out.print("\nIncorrect anwer, please try again! \nDo you wish to enter information for another person (Yes/Y/Continue/No/N/Quit)? ");
            repeat = scanner.nextLine();
         }
      } while (repeat.equalsIgnoreCase("y") || repeat.equalsIgnoreCase("continue") || repeat.equalsIgnoreCase("yes"));
   
      // Output participant list
      System.out.println("\nParticipant List");
      System.out.println("-----------------------------------");
      for (int i = 0; i < participants.size(); i++) {
         System.out.println(participants.get(i).toString());
         System.out.println("-----------------------------------");
      }
   
      // Output total participants and average BMI
      System.out.println("Total participants: " + participants.size());
      System.out.printf("Average BMI: %.1f\n", averageBMI / participants.size());
   
      // Output BMI status breakdown
      System.out.println("BMI Status Breakdown:");
      System.out.println("\tUnderweight: " + underweightCount);
      System.out.println("\tHealthy Weight: " + healthyWeightCount);
      System.out.println("\tOverweight: " + overweightCount);
      System.out.println("\tObese: " + obeseCount);
   }
} // Close DemoHarris class
