import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int SizeOfArray = 3;
        int[] IntArray1 = {1, 2, 3, 4, 5};
        int[] IntArray2 = new int[SizeOfArray];
        int[] IntArray3 = new int[SizeOfArray];
        String[][] TwoDimArray = {{"Du", "Hurensohn"}, {"Mies", "kein", "Bock", "mehr"}}; 

        Arrays.fill(IntArray3, 1);

        String ArrayString = Arrays.toString(IntArray3);
        String TwoDimString = Arrays.deepToString(TwoDimArray);
        
        for (int i = 0; i < IntArray2.length; i++) {
            IntArray2[i] = i;
        }

        System.out.println("The array has "+ IntArray1.length + " elements");
        System.out.println("The array has "+ IntArray2.length + " elements");

        for (int i : IntArray1) {
            System.out.println(i);
        }

        System.out.print("\n");

        for (int i : IntArray2) {
            System.out.println(i);
        }

        System.out.print("\n");

        System.out.println(ArrayString);

        System.out.print("\n");

        System.out.println(TwoDimString);

    }
}
