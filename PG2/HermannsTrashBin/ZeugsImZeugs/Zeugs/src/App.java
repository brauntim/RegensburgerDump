public class App {
    public static void main(String[] args) throws Exception {
        int byte1 = 5;                      //Binär: 0000 0101 -> 1111 1010
        int compByte1 = ~byte1;             // -6

        int x = 5;
        int y = 3;

        String string1 = "Grüße";
        String string2 = "Grüße";

        if (byte1 == x) {
            System.out.println("Values are equal");
        }

        System.out.println(compByte1);
        System.out.println(x % y);                                              // = 2
        System.out.println(x & y);                                              // = 1
        System.out.println(x << 1);                                             // = 10

        System.out.println(5 + 6 * 2);                                          // = 17
        System.out.println((5 + 6) * 2);                                        // = 22
        System.out.println(x++ * 2);                                            // = 10
        System.out.println(x * 2);                                              // = 12

        System.out.println("Sum of 2 and 3 equals " + 2 + 3);                   // = 23
        System.out.println("Sum of 2 and 3 equals " + (2 + 3));                 // = 5

        if (byte1 == x) {
            System.out.println("Values are equal");
        }

        else {
            System.out.println("Values are not equal anymore");
        }

        if (string1.equals(string2)) {
            System.out.println("Strings are equal");
        }
    }
}
