public class MathException extends Exception {

    private double x;
    private double y;

    public MathException(String message, double x, double y) {

        super(message);

        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
