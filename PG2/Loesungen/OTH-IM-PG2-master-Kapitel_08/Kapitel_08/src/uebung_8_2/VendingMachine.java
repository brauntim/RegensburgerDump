package uebung_8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {

	Scanner sc = new Scanner(System.in);

	// The vendingmachine contains one slot for each beverage
	private ArrayList<Bottle> beverageSlot1; // Cola
	private ArrayList<Bottle> beverageSlot2; // Lemonade
	private ArrayList<Bottle> beverageSlot3; // Water

	// Stores how many coins of each kind are left over
	private int counter10Cents = 10;
	private int counter20Cents = 5;
	private int counter50Cents = 2;

	public VendingMachine() {
		beverageSlot1 = new ArrayList<>();
		beverageSlot2 = new ArrayList<>();
		beverageSlot3 = new ArrayList<>();
		// fill the machine
		for (int i = 0; i < 2; i++) {
			this.beverageSlot1.add(new Bottle(BeverageKind.COLA));
			this.beverageSlot2.add(new Bottle(BeverageKind.LEMONADE));
			this.beverageSlot3.add(new Bottle(BeverageKind.WATER));
		}
	}

	private void showAvailableBeverages() {
		System.out.println("Bitte waehlen Sie ein Getraenk aus:");
		// Check if the selected beverage is available and print some information about
		// it if so
		if (!this.beverageSlot1.isEmpty()) {
			Bottle bottle = this.beverageSlot1.get(0);
			System.out.println(bottle.getBeverageKind());
		}
		if (!this.beverageSlot2.isEmpty()) {
			Bottle bottle = this.beverageSlot2.get(0);
			System.out.println(bottle.getBeverageKind());
		}
		if (!this.beverageSlot3.isEmpty()) {
			Bottle bottle = this.beverageSlot3.get(0);
			System.out.println(bottle.getBeverageKind());
		}
	}

	public void chooseAndPayBeverage() {
		ArrayList<Bottle> choosenBeverage = null;
		Bottle bottle = null;

		while (true) {
			showAvailableBeverages();
			// the users choice
			int userChoice = this.sc.nextInt();
			this.sc.nextLine();

			if (userChoice > 3 || userChoice < 1) {
				System.out.println("Inkorrekte Eingabe. Erneut versuchen: ");
				continue;
			}

			switch (userChoice) {
			case 1:
				choosenBeverage = beverageSlot1;
				break;
			case 2:
				choosenBeverage = beverageSlot2;
				break;
			case 3:
				choosenBeverage = beverageSlot3;

			default:
				break;
			}
			if (!choosenBeverage.isEmpty()) {
				bottle = choosenBeverage.get(0);
				break;
			}
			else {
				System.out.println("Diese Sorte ist leider leer!");
			}
		}

		// When the user has made a valid choice, he needs to pay.
		int unpayedCents = bottle.getBeverageKind().getPriceInEuroCents();
		while (unpayedCents > 0) {
			System.out.println("Bitte werfen Sie noch " + unpayedCents
					+ " Cent ein. Gueltige Münzen: (10: 10 Cent, 20: 20 Cent, 50: 50 Cent)");
			int enteredCents = this.sc.nextInt();
			this.sc.nextLine();

			switch (enteredCents) {
			case 10:
				this.counter10Cents++;
				break;
			case 20:
				this.counter20Cents++;
				break;
			case 50:
				this.counter50Cents++;
				break;

			default:
				enteredCents = 0;
				System.out.println("Inkorrekte Eingabe. Erneut versuchen: ");
				break;
			}
			unpayedCents -= enteredCents;
		}

		// Lösungsvorschlag der Teilaufgabe 8.2.2
		if (unpayedCents < 0) {
			System.out.println("Wechselgeld zurueckgeben: " + Math.abs(unpayedCents) + " Cent");
			// Es wird nie passieren, dass 50 Cent zurückgegeben werden müssen.
			// Daher auch kein Code dafür an dieser Stelle.
			while (unpayedCents <= -20 && this.counter20Cents > 0) {
				this.counter20Cents--;
				unpayedCents += 20;
				System.out.println(" - 20 Cent zurueck");
			}
			while (unpayedCents <= -10 && this.counter10Cents > 0) {
				this.counter10Cents--;
				unpayedCents += 10;
				System.out.println(" - 10 Cent zurueck");
			}

			if (unpayedCents < 0) {
				System.out.println("Leider kein Wechselgeld mehr vorhanden!");
			}
		}

		System.out.println("Vielen Dank fuer Ihren Kauf. Bitte entnehmen Sie Ihre Flasche "
				+ bottle.getBeverageKind().getDescription() + ".");

		// remove the bottle the user bought
		choosenBeverage.remove(bottle);
	}

	public void printStatusReport() {
		System.out.println("STATUSREPORT:");

		// Printing the slots
		System.out.println("Slot 1:         " + this.beverageSlot1);
		System.out.println("Slot 2:         " + this.beverageSlot2);
		System.out.println("Slot 3:         " + this.beverageSlot3);

		// printing the coins
		System.out.println("10-Cent-Münzen: " + this.counter10Cents);
		System.out.println("20-Cent-Münzen: " + this.counter20Cents);
		System.out.println("50-Cent-Münzen: " + this.counter50Cents);
	}
}
