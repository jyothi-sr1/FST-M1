package Activities;

	import java.util.ArrayList;
	import java.util.Date;

	class Plane {
	    // Private fields
	    private int maxPassengers;
	    private ArrayList<String> passengers;
	    private Date lastTimeLanded;
	   	    
	    // Constructor to initialize maxPassengers and passengers list
	    public Plane(int maxPassengers) {
	        this.maxPassengers = maxPassengers;
	        this.passengers = new ArrayList<>();
	    }
	    
	    // Method to onboard passengers
	    public void onboard(String passenger) {
	        if (passengers.size() < maxPassengers) {
	            passengers.add(passenger);
	        } else {
	            System.out.println("Cannot onboard more passengers. Plane is full.");
	        }
	    }
	    
	    // Method to take off, returns the current date and time
	    public Date takeOff() {
	        return new Date(); // Current date and time
	    }
	    
	    // Method to land, sets the last time landed and clears the passengers list
	    public void land() {
	        lastTimeLanded = new Date(); // Current date and time
	        passengers.clear(); // Clear the passengers list after landing
	    }
	    
	    // Getter for lastTimeLanded
	    public Date getLastTimeLanded() {
	        return lastTimeLanded;
	    }
	    
	    // Getter for the passengers list
	    public ArrayList<String> getPassengers() {
	        return passengers;
	    }
	}

