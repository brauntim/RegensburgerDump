package uebung_3_05;

import java.util.Scanner;

public class DateCheck {
	public static void main(String[] args) {
		int day, month, year;
		Scanner sc = new Scanner(System.in);

		// read user-input
		System.out.println("Geben Sie ein Datum ein:");
		System.out.print("Tag:\t");
		day = sc.nextInt();
		// needs to be put after each sc.nextInt() or similar because these methods do
		// not read the \n
		sc.nextLine();
		System.out.print("Monat:\t");
		month = sc.nextInt();
		sc.nextLine();
		System.out.print("Jahr:\t");
		year = sc.nextInt();
		sc.nextLine();
		sc.close();

		// check if the input for day is valid
		if (day <= 0 || day > getDaysOfMonth(month, year)) {
			System.err.println("Der eingegebene Tag ist nicht korrekt!");
			System.exit(1); // Exit with code 1, so we see that a error occurred
		}

		// check if the input for month is valid
		if (month < 1 || month > 12) {
			System.err.println("Der eingegebene Monat ist nicht korrekt!");
			System.exit(1);
		}

		// check if the input for year is valid
		if (year <= 1582) {
			if (month <= 10) {
				if (day < 16) {
					System.err.println("Das eingegebene Datum muss nach dem 15.10.1582 liegen!");
					System.exit(1);
				}
			}
		}

		System.out.println(String.format("Der %d.%d.%d ist ein valides Datum.", day, month, year));
	}

	public static int getDaysOfMonth(int month, int year) {
		// February
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			}
			else {
				return 28;
			}
		}

		// Other months
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		}
		else {
			return 31;
		}
	}

	public static boolean isLeapYear(int year) {
		boolean leapYear = false;

		if (year % 4 == 0) {
			leapYear = true;
		}
		if (year % 100 == 0) {
			leapYear = false;
		}
		if (year % 400 == 0) {
			leapYear = true;
		}

		return leapYear;
	}
}
