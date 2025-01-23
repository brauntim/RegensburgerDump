import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] intArray = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};

        for (int outer = 0; outer < intArray.length; outer++) {
            for (int inner = 0; inner < intArray[outer].length; inner++) {
                System.out.print("The array at position: ");
                System.out.println(outer + "|" + inner + ": " + intArray[outer][inner]);
            }
        }

        // or just

        String arrayToString = Arrays.deepToString(intArray);
        
        System.out.println(arrayToString);
    }
}
