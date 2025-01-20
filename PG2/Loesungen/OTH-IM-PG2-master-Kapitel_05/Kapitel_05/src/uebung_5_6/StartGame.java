package uebung_5_6;

import java.util.Scanner;

import uebung_5_6.data.*;
import uebung_5_6.errors.*;

public class StartGame {

	/**
	 * 
	 * @param args [0] ist der Name des Ersten Spielers, [1] ist das Zeichen des
	 *             ersten Spielers, [2] ist der Name des zweiten Spielers, [3] ist
	 *             das Zeichen des zweiten Spielers
	 */
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		try {
			char playstonePlayer1 = 'X';
			char playstonePlayer2 = 'O';

			MatchFourGame game = new MatchFourGame("Spieler 1", playstonePlayer1, "Spieler 2", playstonePlayer2);

			System.out.println(game.getField().toString());

			try {
				while (!game.playGame(scanner)) {
				}

				System.out.println("Spieler " + game.getActivePlayer().getName() + " mit Zeichen "
						+ game.getActivePlayer().getPlayStone() + " gewinnt!");
				System.out.println("!!Glueckwunsch!!");
			}
			catch (FieldIsFullException e) {
				System.out.println(e.getMessage());
				System.out.println("!!Unentschieden!!");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Es ist ein Fehler aufgetreten!");
		}
		finally {
			scanner.close();
		}
	}

}
