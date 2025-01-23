import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] num = new int[5 ];
        Random random = new Random();

        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(1000);
        }

        System.out.println(Arrays.toString(num));
        SortingAlgo(num);
        System.out.println(Arrays.toString(num));
    }

    private static void SortingAlgo (int[] num) {
        int length = num.length;
        for (int i = 0; i < length - 1; i++) {
            int indexOfmin = i;
            for (int j = i + 1; j < length; j++) {
                if (num[j] < num[i]) {
                    indexOfmin = j;
                }
            Swap(num, i, indexOfmin);
            }
        }
    }

    private static void Swap (int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}
