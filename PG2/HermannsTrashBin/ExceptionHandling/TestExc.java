public class TestExc {
    public static void main(String[] args) {
        try {
            divideException(1, 0); 
            divide(1, 1);
        } catch (MathException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    
    public static double divide(double x, double y) throws MathException {
        if (x == 0 || y == 0) {
            throw new MathException("Either x or y is 0", x , y);
        }
        return x / y;
    }

    public static int divideException(int a, int b) {
        return a / b;
    }
}