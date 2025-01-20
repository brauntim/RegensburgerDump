package uebung_3_04;

import java.util.Scanner;

public class ExchangeRateCalculator {
	public static void main(String[] args) {
		double exchangeRate = 1.2756;
		double euroInput = 0.0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie ihren Betrag in Euro ein");
		euroInput = sc.nextDouble();
		sc.nextLine();
		sc.close();

		System.out.println(
				String.format("Sie haben %.2f Euro, das entspricht %.2f Dollar.", euroInput, euroInput * exchangeRate));
	}
}
