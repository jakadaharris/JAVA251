public class Course
//open the class
{

   //fields 
  
   private String courseNumber, courseName; 
   private double contactHours, creditHours;
   private final double COST_PER_HR = 72;
   private TextBook textbook; //Instance of the Textbook class
   
   
   
   /* Constructor to initialize fields
   @param cNum - course number
   @param cName - course name
   @param contHrs - course contact hours
   @param credHrs - course credit hours
   @param book - a TextBook object
   
   */
     
   public Course( String cNum, String cName, double contHrs, double credHrs, TextBook book)
   {
   
   
      courseNumber = cNum;
      courseName = cName;
      contactHours = contHrs;
      creditHours = credHrs;
      textbook = new TextBook(book);//we use the copy contructor of the TextBook class to avoid security holes
   }
   
   
   //Setter methods 
      
   /**
      @param cNum - the course number
  */  
   public void setCourseNumber(String cNum)
   {
      courseNumber = cNum;
   }

   /**
      @param cName - the course name
  */  


   public void setCourseName(String cName)
   {
      courseName = cName;
   }

   /**
      @param cHours - the contact hours  
   */  


   public void setContactHours(double contHrs)
   {
      contactHours = contHrs;
   }

   /**
      @param creditHours - the credit hours  */  


   public void setCreditHours(double credHrs)
   {
      creditHours = credHrs;
   }
   
   /**
      @param book - a TextBook object  
   */  
   
   public void setTextBook(TextBook book)
   {
      textbook = new TextBook(book);
   }

 //Getters
   
   /**
      getCourseNumber method
      @return - the value in the courseNumber field
   */
   
   public String getCourseNumber()
   {
      return courseNumber;
   }

  /**
      getCourseName method
      @return - the value in the courseName field
  */

   public String getCourseName()
   {
      return courseName;
   }
 
   
   /**
      getContactHours method
      @return - the value in the contactHours field
   */
   
   public double getContactHours()
   {
      return contactHours;
   }
   
   /**
      getCreditHours method
      @return - the value in the creditHours field
   */

   public double getCreditHours()
   {
      return creditHours;
   }
   
  /**
      getTextBook method
      @return - return a reference to a copy of this course's TextBook object
  */

   
   public TextBook getTextBook()
   {
      return new TextBook(textbook); 
   }

   /**
      getTuitionCost method
      @return - return the value from the calculation
      
   */
    
   public double getTuitionCost()
   {
      return creditHours * COST_PER_HR;
   }
   
   /**
   
      getTotalPrice method
      @return - return the value from the calculation       
   */
   
   public double getTotalPrice()
   {
      return getTuitionCost() + textbook.getPrice();
   }
   
   /*
      toString method
      @return - A string containing the course information
  */ 
      
  /* We make use of the String.format method to format the tuition cost and total cost. See Chapter 3 for information about this method.*/
   
   public String toString()
   {
      return String.format("Course Name: " + courseName +
             "\nCourse Number: " + courseNumber +
             "\nContact Hours: " + contactHours +
             "\nCredit Hours: " + creditHours +
             "\nTuition Cost: $%.2f" +
             "\nText Book: " + textbook.toString() + //we use the TextBook's toString() method for convenience here
             "\nTotal Price: $%.2f \n", getTuitionCost(), getTotalPrice());
         
   }
      
//close the class     
} 
