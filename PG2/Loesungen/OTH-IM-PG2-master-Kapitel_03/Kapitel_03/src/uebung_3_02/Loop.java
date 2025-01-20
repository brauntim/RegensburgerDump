package uebung_3_02;

import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		int max, div;
		Scanner sc = new Scanner(System.in);

		// read "max"
		System.out.println("max: ");
		while ((max = sc.nextInt()) < 0) {
			System.out.println("Bitte eine positive Zahl eingeben: ");
		}
		// needs to be put after each sc.nextInt() or similar because these methods do
		// not read the \n
		sc.nextLine();

		// read "div"
		System.out.println("div: ");
		while ((div = sc.nextInt()) < 0) {
			System.out.println("Bitte eine positive Zahl eingeben: ");
		}
		sc.nextLine();
		sc.close();

		System.out.println("--- Ergebnis ---");
		for (int i = 0; i <= max; i++) {
			// if i % div is zero, i can be divided by div and we have to print it
			if ((i % div) == 0) {
				System.out.println(i);
			}
		}
	}
}
