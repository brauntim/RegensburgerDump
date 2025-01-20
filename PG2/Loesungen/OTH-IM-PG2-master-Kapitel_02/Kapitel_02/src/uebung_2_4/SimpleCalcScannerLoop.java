package uebung_2_4;

import java.util.Scanner;

public class SimpleCalcScannerLoop {
	public static void main(String[] args) {
		int numberOfInputs = 0; // Counter for numbers been entered
		String entireInput = "";
		double resultingSum = 0.0;
		double resultingProduct = 1.0;
		double currentInput = 0.0;

		Scanner sc = new Scanner(System.in);

		// Endless loop, to enter as many numbers as the user wants
		while (true) {
			// Check if at least two numbers have been entered.
			if (numberOfInputs >= 2) {
				System.out.print("Weitere Zahl eingeben (0/1)? ");
				// If the user enters zero, we break out of the loop.
				if (sc.nextInt() == 0) {
					break;
				}
			}

			// Let the user enter a number
			System.out.println("Bitte Zahl eingeben: ");
			currentInput = sc.nextDouble();

			entireInput += String.format("%.2f, ", currentInput);
			resultingSum += currentInput;
			resultingProduct *= currentInput;

			numberOfInputs++;
		}

		sc.close();

		// Output
		System.out.println("--------------------------");
		System.out.println(String.format("Sie haben eingegeben: %s", entireInput));
		System.out.println("Gesamtsumme:   " + resultingSum);
		System.out.println("Gesamtprodukt: " + resultingProduct);
	}
}
