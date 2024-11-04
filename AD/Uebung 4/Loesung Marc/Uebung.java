import java.util.Random;
import java.time.*;

public class Uebung {
    
    static void MaxToBackBubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j] < a[j-1]) {
                    int h = a[j];
                    a[j] = a[j-1];
                    a[j-1] = h;
                }
            }
        }
    }

    static void MinInsertionSort(int a[]) {
        int i, j, key;
        for (j = a.length - 2; j >= 0; j--) {
            key = a[j];
            i = j + 1;
            while (i <= a.length - 1 && a[i] < key) {
                a[i-1] = a[i];
                i = i+1;
            }
            a[i-1] = key;
        }
    }

    static void MaxSelectionSort(int a[]) {
        int i, j, max;
        for (i = a.length - 1; i >= 0; i--) {
            max = i;
            for (j = i; j >= 0; j--) {
                if (a[j] > a[max]) max = j;
            }
            int h = a[i];
            a[i] = a[max];
            a[max] = h;
        }
    }

    static int part = 0;

    private static final Random random = new Random();

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(arr, begin, end);
            quickSort(arr, begin, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivotIndex = begin + random.nextInt(end - begin + 1);
        swap(arr, pivotIndex, end);
        
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void randomfill(int[] array) {
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(0,99);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = new int[150000];
        randomfill(array);
        //MinInsertionSort(array);
        //MaxToBackBubbleSort(array);
        //MaxSelectionSort(array);
        MaxToBackBubbleSort(array);
        long stop = System.currentTimeMillis();
        System.out.println("Runtime in s: " + (stop-start)/1000);
    }
}

class RecursiveInsertionSort {
    public static void insertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        insertionSort(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {34, 45, 12, 34, 23};
        insertionSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class IterativeMergeSort {
    public static void mergeSort(int[] arr) {
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
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 45, 12, 34, 23};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
