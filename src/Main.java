import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        while (true) {
            System.out.println("Please enter an integer for the array length.");
            int arrayLength = scanner.nextInt();
            startTime = System.currentTimeMillis();
            int[] array = createRandomArray(arrayLength);
            double arrayTime = Double.valueOf((double) (System.currentTimeMillis() - startTime) / 1000D);
            System.out.printf("\nThe time of creating an Array for size %d is %.6fs\n", new Object[] {
                Integer.valueOf(arrayLength), arrayTime});
            System.out.println();

            startTime = System.currentTimeMillis();
            int[] sortedArray = mergeSort(array);
            System.out.println("Merge sort integer of current array of length: " + arrayLength);
            printArray(sortedArray);
            double sortedTime = Double.valueOf((double) (System.currentTimeMillis() - startTime) / 1000D);
            System.out.printf("\nThe time of sorting the array using merge sort for size %d is %.6fs\n", new Object[] {
                Integer.valueOf(arrayLength), sortedTime});
            System.out.println("The sorted array is in the correct order: " + isSorted(sortedArray));
            System.out.println();

            startTime = System.currentTimeMillis();
            int[] bubbleArray = bubbleSort(array);
            System.out.println("Bubble sort integer of current array of length: " + arrayLength);
            double bubbleTime = Double.valueOf((double) (System.currentTimeMillis() - startTime) / 1000D);
            System.out.printf("\nThe time of sorting the array using bubble sort for size %d is %.6fs\n", new Object[] {
                Integer.valueOf(arrayLength), bubbleTime});
            System.out.println("Merged Sort and Bubble sort created the same result? Answer: " + Arrays.equals(sortedArray , array));
            System.out.println();
            printArray(bubbleArray);

            System.out.println();
            System.out.println("Would you like to continue? Yes or no?");
            String answer = scanner.next();
            if (answer.equals("no")) break;
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j +1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (j < array1.length && k < array2.length) {
            if (array1[j] <= array2[k]) {
                mergedArray[i++] = array1[j++];
            } else {
                mergedArray[i++] = array2[k++];
            }
        }
        while (j < array1.length) {
            mergedArray[i++] = array1[j++];
        }
        while (k < array2.length) {
            mergedArray[i++] = array2[k++];
        }
        return mergedArray;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int arrayLength1 = array.length / 2;
            int[] array1 = Arrays.copyOfRange(array, 0, arrayLength1);
            int[] array2 = Arrays.copyOfRange(array, arrayLength1, array.length);
            array1 = mergeSort(array1);
            array2 = mergeSort(array2);
            int[] mergedArray = merge(array1, array2);
            return mergedArray;
        }
    }

    public static int[] createRandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
		}
		return array;
	}
}