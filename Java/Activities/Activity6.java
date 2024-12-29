package Activities;

import java.util.Date;

public class Activity6 {
		    public static void main(String[] args) throws InterruptedException {
	        // Create a plane with max 10 passengers
	        Plane plane = new Plane(10);
	        
	        // Onboard passengers
	        plane.onboard("Alice");
	        plane.onboard("Bob");
	        plane.onboard("Charlie");
	        
	        // Take off and print the take off time
	        Date takeOffTime = plane.takeOff();
	        System.out.println("Take off time: " + takeOffTime);
	        
	        // Print the list of passengers
	        System.out.println("Passengers on board: " + plane.getPassengers());
	        
	        // Simulate the plane in flight (sleep for 5 seconds)
	        Thread.sleep(5000); // 5000 milliseconds = 5 seconds
	        
	        // Land the plane and print the landing time
	        plane.land();
	        System.out.println("Landing time: " + plane.getLastTimeLanded());
	    }
	}

