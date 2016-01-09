import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int minLength = 1001;
        // Build array of stick lengths and record the minimum length.
        minLength = storeSticksAndMinLength(in, n, arr, minLength);
        // Loop until the minimum length is zero.
        while (minLength > 0) {
            // Print the count of sticks that haven't been eliminated.
            printCurrentStickCount(arr);
            // Cut all the sticks down by the minimum length.
            int newMinLength = 1001;
            newMinLength = storeCutLengthsAndMinLength(
            		arr,
            		minLength,
					newMinLength);
            // Reset the minimum length
            minLength = updateMinLength(newMinLength);  
        }
    in.close();
    }

	private static int storeSticksAndMinLength(
			Scanner in,
			int n,
			int[] arr,
			int minLength) {
		for(int arr_i=0; arr_i < n; arr_i++){
            int stickLength = in.nextInt();
            arr[arr_i] = stickLength;
            if (stickLength < minLength) {
                minLength = stickLength;
            }
        }
		return minLength;
	}
	
	private static void printCurrentStickCount(int[] arr) {
		int cutCount = 0;
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] > 0) {
		        cutCount++;
		    }
		}
		System.out.println(cutCount);
	}
	
	private static int storeCutLengthsAndMinLength(
			int[] arr,
			int minLength,
			int newMinLength) {
		for (int i = 0; i < arr.length; i++) {
		    int newLength = arr[i] - minLength;
		    arr[i] = newLength;
		    // Set the new min length to the shortest
		    // remaining stick after cutting.
		    if (0 < newLength && newLength < newMinLength) {
		        newMinLength = newLength;
		    }
		}
		return newMinLength;
	}
	
	private static int updateMinLength(int newMinLength) {
		int minLength;
		if (newMinLength < 1001) {
		    minLength = newMinLength;
		}
		else {
		    minLength = 0;
		}
		return minLength;
	}
}