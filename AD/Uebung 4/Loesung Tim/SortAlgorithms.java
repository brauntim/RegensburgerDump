package SortMethods;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie die Anzahl der Elemente im Array ein:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Geben Sie die Array-Elemente ein:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Wählen Sie eine Sortiermethode:");
        System.out.println("1 - Insertion Sort");
        System.out.println("2 - Bubble Sort");
        System.out.println("3 - Selection Sort");
        System.out.println("4 - Quick Sort");
        System.out.println("5 - Recursive Insertion Sort");
        System.out.println("6 - Iterative Merge Sort");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                reverseInsertionSort(arr);
                System.out.println("Array sortiert mit Insertion Sort:");
                break;
            case 2:
                bubbleSort(arr);
                System.out.println("Array sortiert mit Bubble Sort:");
                break;
            case 3:
                modifiedSelectionSort(arr);
                System.out.println("Array sortiert mit Selection Sort:");
                break;
            case 4:
                modifiedQuickSort(arr, 0, arr.length - 1);
                System.out.println("Array sortiert mit Quick Sort:");
                break;
            case 5:
                recursiveInsertionSort(arr,arr.length);
                System.out.println("Array sortiert mit Rekursiven Iteration Sort:");
                break;
            case 6:
                iterativeMergeSort(arr);
                System.out.println("Array sortiert mit Iterativen Merge Sort:");
                break;
            default:
                System.out.println("Ungültige Auswahl.");
                return;
        }

        printArray(arr);
        scanner.close();
    }

    // Insertion Sort
    public static void reverseInsertionSort(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            int key = arr[i];
            int j = i + 1;

            // Verschieben der größeren Elemente nach rechts
            while (j < arr.length && arr[j] < key) {
                arr[j - 1] = arr[j];
                j++;
            }
            arr[j - 1] = key;
        }
    }


    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    // Selection Sort
    public static void modifiedSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int maxIdx = i;

            // Suche das Maximum im unsortierten Bereich
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            // Vertausche das Maximum mit dem Element an der Position `i`
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }



    // Quick Sort

    public static void modifiedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomPartition(arr, low, high);
            modifiedQuickSort(arr, low, pivotIndex - 1);
            modifiedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomPivotIndex = low + rand.nextInt(high - low + 1);

        // Pivot an die letzte Stelle verschieben
        int temp = arr[randomPivotIndex];
        arr[randomPivotIndex] = arr[high];
        arr[high] = temp;

        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    // Ausgabe des Arrays
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }



    public static void recursiveInsertionSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }

        recursiveInsertionSort(array, n - 1);

        int last = array[n - 1];
        int j = n - 2;

        while (j >= 0 && array[j] > last) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = last;
    }

    public static void iterativeMergeSort(int[] arr) {
        int n = arr.length;
        for (int currSize = 1; currSize <= n - 1; currSize = 2 * currSize) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);
                merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }




}
