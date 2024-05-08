import java.util.*; 

/*
The CourseDemo class will allow a user to enter information about a Course
 and a TextBook that is associated with that course.
The demo will promp the user to keep entering Course and TextBook information
 as long as they wish to do so.
When the user is done entering information, it will print out all of the information
 for each of the Courses and their associated TextBooks that the user has entered.
*/

public class CourseDemo
{
   public static void main(String[] args)
   {
      //declare the variables for the Course
      String courseNumber, courseName;
      double contactHours, creditHours, totalTuitionCost = 0;
      
      //declare the variables for the TextBook
      String title, author, publisher;
      double bookCost = 0;
      
      //create the arraylist to store our Course objects
      ArrayList<Course> courses = new ArrayList<Course>();
      
      //to store the user's input on whether they want to enter information for another Course and TextBook
      String goAgain = "N";
      
      //create a Scanner object to read user input     
      Scanner keyboard = new Scanner(System.in);
      
      //use a post test loop so that the user must enter information about at least one Course and TextBook
      do
      {
         //Gather information about the Course
         System.out.println("Enter information about a Course you are taking this semeter. ");
         System.out.println("Enter the course number: ");
         courseNumber = keyboard.nextLine();  
         System.out.println("Enter the course name: ");
         courseName = keyboard.nextLine();
         System.out.println("Enter the number of contact hours: ");
         contactHours = keyboard.nextDouble();
         System.out.println("Enter the number of credit hours: ");
         creditHours = keyboard.nextDouble();
         keyboard.nextLine();//remember to consume the newline character left in the buffer after reading a double!
         
         //we also need to gather information about the TextBook for the Course
         System.out.println("Please enter the following information about the text book required for this course: ");
         System.out.println("Enter the Title: ");
         title = keyboard.nextLine();  
         System.out.println("Enter the Author's Name: ");
         author = keyboard.nextLine();
         System.out.println("Enter the Publisher's Name: ");
         publisher = keyboard.nextLine();
         System.out.println("Enter the Cost: ");
         bookCost = keyboard.nextDouble();
         
         
         //now we create out TextBook object using the information we gathered
         TextBook myTextBook = new TextBook(title, author, publisher, bookCost);
         
         //next, we create the Course itself, and pass it all of the information, including our TextBook instance we just created
         Course myCourse = new Course(courseNumber, courseName, contactHours, creditHours, myTextBook);
         
         //next, add the Course to our ArrayList of courses
         courses.add(myCourse);
         
         //next, ask the user if they would like to enter information for another Course and TextBook
         System.out.println("Do you wish to enter information about another Course? Enter 'Y' for yes or anything else to exit.");
         keyboard.nextLine();//consume the newline character left in the buffer from our last call to nextDouble()
         goAgain = keyboard.nextLine();
      }
      while(goAgain.charAt(0) =='y' || goAgain.charAt(0) =='Y');
      
      //finally, we want to print out all of the information about the Courses we just created
      //since the TextBook is part of the Course because it is an aggregate field, we will also receive information about the TextBook
      for(int i=0; i < courses.size(); i++)
      {
         System.out.println("Course Information:");
         System.out.println(courses.get(i));//notice how the toString() method does not need to be explicitly called when printing out information of our Course class
         System.out.println();//print a blank line between Courses for easier readability
      }
   }
}