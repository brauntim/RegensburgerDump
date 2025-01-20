package uebung_3_10;

import java.util.Scanner;

public class RomanNumbers {
	static String[] romanNumbers = new String[] { "", "I", "V", "X", "L", "C", "D" };
	static int[] decimalBlocks = new int[] { 0, 1, 5, 10, 50, 100, 500 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int decimalNumber;

		do {
			// check for valid input
			System.out.println("Geben Sie eine Dezimalzahl zwischen 1 und 999 ein:");
			decimalNumber = sc.nextInt();
			sc.nextLine();
		}
		while (decimalNumber < 1 || decimalNumber > 999);

		sc.close();

		String simpleRomanNumber = simpleConversion(decimalNumber);
		System.out.println("Einfache Umrechnung: " + simpleRomanNumber);

		String subtractionRuleRomanNumber = subtractionRuleConversion(decimalNumber);
		System.out.println("Subtraktionsregel:   " + subtractionRuleRomanNumber);
	}

	// 3.10.1
	public static String simpleConversion(int decimalNumber) {
		String romanNumber = "";

		for (int i = decimalBlocks.length - 1; i >= 0; i--) {
			while (decimalNumber >= decimalBlocks[i] && decimalBlocks[i] != 0) {
				decimalNumber -= decimalBlocks[i];
				romanNumber += romanNumbers[i];
			}
		}

		return romanNumber;
	}

	// 3.10.2
	public static String subtractionRuleConversion(int decimalNumber) {
		String romanNumber = "";

		for (int i = decimalBlocks.length - 1; i > 0; i--) {
			while (decimalNumber > decimalBlocks[i - 1]) {
				if (decimalNumber >= decimalBlocks[i]) {
					decimalNumber -= decimalBlocks[i];
					romanNumber += romanNumbers[i];
				}
				else {
					// Check whether the number can be printed if we sub the next smaller one.
					// Example: 40 = XL [50 - 10])
					if (decimalNumber == (decimalBlocks[i] - decimalBlocks[i - 1])) {
						decimalNumber -= (decimalBlocks[i] - decimalBlocks[i - 1]);
						romanNumber += romanNumbers[i - 1] + romanNumbers[i];
					}
					else {
						decimalNumber -= decimalBlocks[i - 1];
						romanNumber += romanNumbers[i - 1];
					}
				}
			}
		}

		return romanNumber;
	}
}
