package Activities;

public class Activity4 {
		    // Insertion Sort Method
	    public static void insertionSort(int[] arr) {
	        // Loop through each element 
	        for (int i = 1; i < arr.length; i++) {
	            int key = arr[i];  
	            int j = i - 1;

	            
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];  
	                j = j - 1;
	            }

	            // Place the unsorted card at the correct position
	            arr[j + 1] = key;
	        }
	    }
	    public static void main(String[] args) {
	            int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};

	        // Display the array before sorting
	        System.out.println("Array before sorting:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }

	        // Sort the array using Insertion Sort
	        insertionSort(arr);

	        // Display the array after sorting
	        System.out.println("\nArray after sorting:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	}