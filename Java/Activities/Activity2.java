package Activities;

public class Activity2 {
	public static void main(String[] args) {
        //array with 6 numbers
        int[] numbers = {10, 77, 10, 54, -11, 10};

        // Variable to store the sum of 10's
        int sum = 0;

        // Loop through the array and find 10's
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 10) {
                sum += numbers[i];
            }
        }

        // Checking for sum
        if (sum == 30) {
            System.out.println("True"); // If sum is 30, print True
        } else {
            System.out.println("False"); // If sum is not 30, print False
        }
    }
}


