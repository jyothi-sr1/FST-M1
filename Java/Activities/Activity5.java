package Activities;

	abstract class Book {
	    // Declare a String variable to store the title of the book
	    String title;

	    // Abstract method 
	    public abstract void setTitle(String title);

	    // Concrete method 
	    public String getTitle() {
	        return title;
	    }
	}

	// Derived class MyBook that extends the abstract class Book
	class MyBook extends Book {
	    // Implement the abstract method setTitle()
	    @Override
	    public void setTitle(String title) {
	        this.title = title;
	    }
	}

	public class Activity5 {
	    public static void main(String[] args) {
	        // Create an object for MyBook
	        MyBook newNovel = new MyBook();

	        // Initialize title of the book
	        newNovel.setTitle("The Great Adventure");

	        // Print result
	        System.out.println("Book title: " + newNovel.getTitle());
	    }
	}

