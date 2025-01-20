package uebung_2_3;

// Import of the Scanner-Class from the java lib.
import java.util.Scanner;

public class SimpleCalcScanner {
	public static void main(String[] args) {

		double a;
		double b;

		// Declaring a variable for our scanner object and initialize it with a new
		// scanner object
		Scanner sc = new Scanner(System.in);

		// Asking the user to input a number.
		System.out.println("Bitte die erste Zahl eingeben (Kommazahlen wie 4,0): ");
		a = sc.nextDouble();
		System.out.println("Bitte die zweite Zahl eingeben (Kommazahlen wie 4,0): ");
		b = sc.nextDouble();
		// Closing the scanner because it is a stream and streams should always be
		// closed if we don´t need them anymore.
		// Caution: If the scanner is closed, you can not reopen it.
		sc.close();

		System.out.println("Addition von       " + a + " und " + b + " = " + (a + b));
		System.out.println("Substraktion von   " + a + " und " + b + " = " + (a - b));
		// If the user enters a zero, a division by zero would be made. For this case we
		// initialize result with NaN
		// and only change it if b is different from zero.
		double result = Double.NaN;
		if (b != 0) {
			result = a / b;
		}
		System.out.println("Division von       " + a + " und " + b + " = " + result);
		System.out.println("Multiplikation von " + a + " und " + b + " = " + (a * b));
	}
}
