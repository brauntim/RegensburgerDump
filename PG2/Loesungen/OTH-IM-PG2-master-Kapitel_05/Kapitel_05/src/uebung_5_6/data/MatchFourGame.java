package uebung_5_6.data;

import java.util.Random;
import java.util.Scanner;

import uebung_5_6.errors.*;

public class MatchFourGame {

	private Player player1 = new Player();
	private Player player2 = new Player();
	private Field field = new Field();
	private Player activePlayer;

	public MatchFourGame(String name1, char playstone1, String name2, char playstone2) {
		this.player1.setName(name1);
		this.player2.setName(name2);
		this.player1.setZeichen(playstone1);
		this.player2.setZeichen(playstone2);
		firstActivePlayer(); // Setzt die aktiverSpieler Variable zufällig auf
								// einen Spieler
	}

	// /////////
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	/**
	 * Bestimmt zur Erstellung eines VierGewinntSpiel Objekts, welcher Spieler
	 * anfängt und setzt die Variable aktiverSpieler auf den den anfängt.
	 */
	public void firstActivePlayer() {

		Random random = new Random();

		int firstPlayer = (random.nextInt()) % 2;

		if (firstPlayer == 0) {
			activePlayer = player1;
		}
		else {
			activePlayer = player2;
		}
		System.out.println(activePlayer.getName() + " mit Zeichen " + activePlayer.getPlayStone() + " faengt an.");
	}

	/**
	 * Kümmert sich um den Ablauf des Spiels, indem es alle Methoden aufruft um
	 * einen Zug zu machen.
	 * 
	 * @return true, sollte es nach dem das Element gelegt wurde zu einem Sieg
	 *         gekommen sein, sonst false.
	 * @throws FieldIsFullException
	 */
	public boolean playGame(Scanner scanner) throws FieldIsFullException {

		try {
			this.makeMove(scanner);
		}
		catch (ChoiceNotInFieldException e) {
			System.out.println(e.getMessage());
			return false;
		}
		catch (ColumnIsFullException e) {
			System.out.println(e.getMessage());
			return false;
		}

		System.out.println(this.getField().toString());
		if (this.getField().checkWin()) {
			return true;
		}

		this.changePlayer();

		return false;
	}

	/**
	 * Wechselt den aktiven Spieler der aktiverSpieler Variable
	 */
	public void changePlayer() {

		if (this.activePlayer == this.player1) {
			this.activePlayer = this.player2;
		}
		else {
			this.activePlayer = this.player1;
		}
	}

	/**
	 * Kümmert sich um die Auswahl der Spalte, in die der aktiveSpieler das
	 * nächste Element anfügen will und darum, dieses Element in das spielfeld
	 * anzufügen
	 * 
	 * @throws ChoiceNotInFieldException wenn die ausgewählte Spalte des Spielers
	 *                                   keine Spalte im spielfeld ist (zB zu große
	 *                                   Zahl)
	 * @throws ColumnIsFullException     wenn die ausgewählte Spalte bereits
	 *                                   vollständig belegt ist.
	 */
	public void makeMove(Scanner scanner)
			throws ChoiceNotInFieldException, ColumnIsFullException, FieldIsFullException {

		System.out.println("Spieler " + this.activePlayer.getName() + " ist am Zug" + " (Zeichen "
				+ this.activePlayer.getPlayStone() + ").");

		int choice = this.activePlayer.chooseColumn(scanner) - 1;

		if (choice >= this.field.getX()) {
			throw new ChoiceNotInFieldException();
		}

		this.getField().addTile(choice, this.activePlayer);

	}

}
