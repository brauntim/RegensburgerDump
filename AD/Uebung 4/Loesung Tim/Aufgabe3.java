package SortMethods;

import java.util.Arrays;
import java.util.Random;

public class Aufgabe3 {

    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return true;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 10;
        int min = 1;
        int max = 20;
        int[] a = generateRandomArray(size, min, max);
        int s = 25;

        System.out.println("Zufälliges Array: " + Arrays.toString(a));
        System.out.println("Gibt es ein Paar mit Summe " + s + ": " + hasPairWithSum(a, s));
    }
}
