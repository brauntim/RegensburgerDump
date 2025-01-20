package uebung_3_01;

import java.util.Scanner;

public class MorseAlphabet {
	public static void main(String[] args) {
		String morseCode = "";
		String[] decodingTable = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
				"----." };
		Scanner sc = new Scanner(System.in);

		// user input
		System.out.println("Bitte geben Sie nacheinander fuenf 'Morsezeichen' ein und bestaetigen jeweils mit Enter: ");
		for (int i = 0; i < 5; i++) {
			morseCode += sc.nextLine();
		}
		sc.close();

		// convert input to number
		int output = convertMorseCodeToInt(morseCode, decodingTable);

		// check if input could be converted to a number
		if (output >= 0) {
			System.out.println(output);
		}
		else {
			System.err.println("Error: Kein korrekter Morsecode");
		}
	}

	// checking if the user input matches an entry of the decoding table. If so, the
	// index at the matching is also the number.
	public static int convertMorseCodeToInt(String morse, String[] decodingTable) {
		for (int i = 0; i < decodingTable.length; i++) {
			if (morse.equals(decodingTable[i])) {
				return i;
			}
		}
		return -1;
	}
}
