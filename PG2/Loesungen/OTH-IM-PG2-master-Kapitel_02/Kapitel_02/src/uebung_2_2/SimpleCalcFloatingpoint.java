package uebung_2_2;

public class SimpleCalcFloatingpoint {
	public static void main(String[] args) {
		// Declaration and initialization. Using double is better for certain reasons
		// instead of float.
		double a = 5.0;
		double b = 3.0;
		// Result variable
		double resultDouble;

		// Calculating as seen before, but printing the result each time twice. As
		// Double and casted to Integer.

		resultDouble = a + b;
		System.out.println("Addition von       " + a + " und " + b + " (Double) = " + resultDouble);
		System.out.println("Addition von       " + a + " und " + b + " (Int)   = " + (int) resultDouble);

		resultDouble = a - b;
		System.out.println("Substraktion von   " + a + " und " + b + " (Double) = " + resultDouble);
		System.out.println("Substraktion von   " + a + " und " + b + " (Int)   = " + (int) resultDouble);

		resultDouble = a / b;
		System.out.println("Division von       " + a + " und " + b + " (Double) = " + resultDouble);
		System.out.println("Division von       " + a + " und " + b + " (Int)   = " + (int) resultDouble);

		resultDouble = a * b;
		System.out.println("Multiplikation von " + a + " und " + b + " (Double) = " + resultDouble);
		System.out.println("Multiplikation von " + a + " und " + b + " (Int)   = " + (int) resultDouble);

		// If at least one of the for division used variable is a floating point, the
		// result is also floating point.
		int c = 5;
		int d = 3;

		resultDouble = c / d;
		System.out.println("Division von       " + c + " und " + d + " (Beide Integer) = " + resultDouble);

		resultDouble = c / b;
		System.out
				.println("Division von       " + c + " und " + b + " (Eine Integer, eine Double)   = " + resultDouble);
	}
}