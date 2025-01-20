package uebung_3_09;

import java.util.Scanner;
import java.util.Random;

public class Roulette {
	public static void main(String[] args) {
		// init game
		Scanner sc = new Scanner(System.in);
		int blackFields[] = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
		System.out.println("Willkommen beim Roulette");
		int playerMoney = 1000;

		// playing until player runs out of money
		while (playerMoney > 0) {
			System.out.println("Ihr aktuelles Guthaben betraegt " + playerMoney + " Euro.");
			System.out.print("Bitte setzen Sie einen Betrag fuer Ihr naechstes Spiel: ");
			int bet = sc.nextInt();
			sc.nextLine();

			// player can not spend more many than he owns
			if (bet > playerMoney) {
				System.err.println("Der eingesetzte Betrag uebersteigt Ihr Guthaben. Bitte neu setzen.");
				continue;
			}

			System.out.print("Bitte setzen Sie auf eine Farbe (r/s) oder eine Zahl (1-35): ");
			String choice = sc.nextLine();

			// sub bet from players money
			playerMoney -= bet;

			// let the ball run
			int random = getRandomNumber();
			boolean playerWon = false;
			if (choice.equals("r")) {
				// if even the field is red
				if (random != 0 && !isBlackField(random, blackFields)) {
					System.out.println("   " + random + " - Rot gewinnt, Glueckwunsch");
					playerMoney += bet * 2;
					playerWon = true;
				}
			}
			else if (choice.equals("s")) {
				// if uneven the field is black
				if (random != 0 && isBlackField(random, blackFields)) {
					System.out.println("   " + random + " - Schwarz gewinnt, Glueckwunsch");
					playerMoney += bet * 2;
					playerWon = true;
				}
			}
			else {
				int number = Integer.valueOf(choice);
				if (number >= 0 && number <= 36) {
					if (random == Integer.valueOf(choice)) {
						System.out.println("   " + random + " - Sie gewinnen, Glueckwunsch");
						playerMoney += bet * 35;
						playerWon = true;
					}
				}
			}

			if (!playerWon) {
				System.out.println("   " + random + " - Leider verloren");
			}

			System.out.println("--------------------");
		}
		System.out.println("Vielen Dank fuer Ihren Besuch");
		sc.close();
	}
	
	public static int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(37);
	}
	
	public static boolean isBlackField(int number, int[] blackFields) {
		for (int i = 0; i < blackFields.length; i++) {
			if (blackFields[i] == number) {
				return true;
			}
		}
		return false;
	}
}
