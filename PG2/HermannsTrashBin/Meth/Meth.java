import java.math.*;

public class Meth {
    public static void main(String[] args) {
        double result = round(2.453136, 2);
        System.out.println(result);
    }

    public static double round(double number, double decimal) {
        decimal = Math.pow(10, decimal);
        number = number * decimal;
        number = Math.round(number);
        number = number / decimal;
        return number;
    }
}
