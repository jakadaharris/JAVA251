/* This program will use @param and @return documentation to provide practice with using method documentation. 
   You should include this type of documentation in all your programs.*/

/**Create the TextBook class to hold the textbook-related data. 
   An instance of this class will be used as a "field" in the Course class*/

public class TextBook
{

   //fields 
      
   private String title;
   private String author;
   private String publisher;
   private double price;
   
  
  /*Constructor that accepts arguments for the textbook title, author, publisher and the book price
    This constructor can be used to initialize the fields. 
    @param textTitle - book title
    @param auth - author's name
    @param pub - publisher's name
    @param p - the book price
    
  */
  
   public TextBook(String textTitle, String auth, String pub, double p)
   {
      title = textTitle;
      author = auth;
      publisher = pub;
      price = p;
   }
   
   /*The copy constructor creates a copy of the TextBook class that it is passed as a parameter.
     We use this to avoid secuirty holes.  See Chapter 7 for more information about this.
     @param object2 - the object to copy
   */
   public TextBook(TextBook object2)
   {
      title = object2.title;
      author = object2.author;
      publisher = object2.publisher;
      price = object2.price;
   }
   
  /**
      @param textTitle - the book title
  */
   public void setTitle(String textTitle)
   {
      title = textTitle;
   }
   
  /**
      @param auth - the book author
  */

   public void setAuthor(String auth)
   {
      author = auth;
   }
   
   /**
      @param pub - the book publisher
  */

   public void setPublisher(String pub)
   {
      publisher = pub;
   }
   
  
  /**
      @param p - the book price
  */

   public void setPrice(double p)
   {
      price = p;
   }
   
   //Getters
   
 /**
      @return - the value in the title field
 */

   
   public String getTitle()
   {
      return title;
   }
   
 /**
      @return - the value in the author field
 */
   public String getAuthor()
   {
      return author;
   }
 
 /**
      @return - the value in the publisher field
 */
   
   public String getPublisher()
   {
      return publisher;
   }
  
 /**
      @return - the value in the price field
 */
   public double getPrice()
   {
      return price;
   }
   
   /**
      toString method
      @return - A string containing the textbook information
  */ 

   /*
     We make use of the String.format method to format the price. See Chapter 3 for information about this method.
   */
   
   public String toString()
   {
      return String.format("Title: " + title + 
             "\nAuthor: " + author + 
             "\nPublisher: " + publisher +
             "\nPrice: $%.2f \n", price);
   }
}