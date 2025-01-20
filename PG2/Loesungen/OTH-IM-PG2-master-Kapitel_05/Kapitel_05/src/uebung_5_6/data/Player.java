package uebung_5_6.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

	private char playStone;
	private String name = new String();

	public char getPlayStone() {
		return playStone;
	}

	public void setZeichen(char zeichen) {
		this.playStone = zeichen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hier wird der Spieler aufgeforder, in welche Spalte er sein Zeichen setzen
	 * wird.
	 * 
	 * @return Die jeweilige Spalte, in die das Zeichen gesetzt werden soll
	 */
	public int chooseColumn(Scanner scanner) {
		System.out.print("Waehle die Spalte aus: ");

		int choice = 0;

		while (choice == 0) {
			try {
				choice = scanner.nextInt();
				scanner.nextLine();

			}
			catch (InputMismatchException e) {
				System.out.println("Es wurde ein ungueltiges Zeichen eingegeben");
			}
		}
		return choice;
	}

}
