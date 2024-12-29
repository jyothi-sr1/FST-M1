package Activities;

public class Activity1 {
    public static void main(String[] args) {
        // Creating an object of the Car class
        Car myCar = new Car("Red", "Automatic", 2024);

        // Displaying the characteristics of the car
        myCar.displayCharacteristics();

        // Testing the methods
        myCar.accelerate();
        myCar.brake();
    }
}