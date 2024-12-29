package Activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	//constructor
	public Car(String color, String transmission, int make) {
        this.color = color;
        this.transmission = transmission;
        this.make = make;
        this.tyres = 4;  // Default value for tyres
        this.doors = 4;  // Default value for doors
    }
	//
	public void displayCharacteristics() {
        System.out.println("Car Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make Year: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }
	public void accelerate() {
        System.out.println("Car is moving forward.");
    }
	public void brake() {
        System.out.println("Car has stopped.");
    }
}

	
	
	


