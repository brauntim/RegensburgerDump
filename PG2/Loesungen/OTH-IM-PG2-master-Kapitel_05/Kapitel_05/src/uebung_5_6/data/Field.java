package uebung_5_6.data;

import uebung_5_6.errors.*;

public class Field {

	final private int x = 7;
	final private int y = 6;
	private char[][] gamefield = new char[y][x];
	private int moves = 0;

	public Field() {
		for (int y = 0; y < this.y; y++) {
			for (int x = 0; x < this.x; x++) {
				this.gamefield[y][x] = ' ';
			}
		}
	}

	public char[][] getGamefield() {
		return gamefield;
	}

	public void setGamefield(char[][] gamefield) {
		this.gamefield = gamefield;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		String gamefieldString = new String();
		for (int x = 0; x < this.x; x++) {
			gamefieldString += "  " + (x + 1) + " ";
		}
		gamefieldString += "\n";
		for (int y = 0; y < this.y; y++) {
			gamefieldString += "| ";
			for (int x = 0; x < this.x; x++) {
				gamefieldString += this.gamefield[y][x];
				gamefieldString += " | ";
			}
			gamefieldString += "\n";
		}
		gamefieldString += "|";
		for (int x = 0; x < this.x - 1; x++) {
			gamefieldString += "____";
		}
		gamefieldString += "___|";
		return gamefieldString;
	}

	/**
	 * Fügt dem Spielfeld ein neues Element hinzu
	 * 
	 * @param column Spalte in der versucht wird, das neue Element einzufügen
	 * @param player Spieler, der das Element einfügt
	 * @throws ColumnIsFullException Wird geworfen, wenn die Spalte voll ist, und
	 *                               das Element nicht eingefügt werden kann.
	 */
	public void addTile(int column, Player player) throws ColumnIsFullException, FieldIsFullException {
		if (this.gamefield[0][column] == ' ') {
			for (int y = this.y - 1; y >= 0; y--) {
				if (this.gamefield[y][column] == ' ') {
					this.gamefield[y][column] = player.getPlayStone();
					this.moves++;
					return;
				}
			}
		}
		else if (this.moves == this.x * this.y) {
			throw new FieldIsFullException();
		}
		else {
			throw new ColumnIsFullException();
		}
	}

	/**
	 * Überprüft, ob im spielfeld eine Konstellation vorliegt, die einen Sieg für
	 * einen Spieler bedeutet.
	 * 
	 * @return true, falls ein Sieg vorliegt. Sonst false.
	 */
	public boolean checkWin() {

		// Check die Zeilen
		for (int y = 0; y < this.y; y++) {
			for (int x = 0; x < this.x - 3; x++) {
				if (gamefield[y][x] != ' ' && gamefield[y][x] == gamefield[y][x + 1]
						&& gamefield[y][x] == gamefield[y][x + 2] && gamefield[y][x] == gamefield[y][x + 3]) {
					return true;
				}
			}
		}
		// Check die Reihen
		for (int y = 0; y < this.y - 3; y++) {
			for (int x = 0; x < this.x; x++) {
				if (gamefield[y][x] != ' ' && gamefield[y][x] == gamefield[y + 1][x]
						&& gamefield[y][x] == gamefield[y + 2][x] && gamefield[y][x] == gamefield[y + 3][x]) {
					return true;
				}
			}
		}
		// Check die fallenden Diagonalen
		for (int y = 0; y < this.y - 3; y++) {
			for (int x = 0; x < this.x - 3; x++) {
				if (gamefield[y][x] != ' ' && gamefield[y][x] == gamefield[y + 1][x + 1]
						&& gamefield[y][x] == gamefield[y + 2][x + 2] && gamefield[y][x] == gamefield[y + 3][x + 3]) {
					return true;
				}
			}
		}
		// Check die steigenden Diaglonalen
		for (int y = 3; y < this.y; y++) {
			for (int x = 0; x < this.x - 3; x++) {
				if (gamefield[y][x] != ' ' && gamefield[y][x] == gamefield[y - 1][x + 1]
						&& gamefield[y][x] == gamefield[y - 2][x + 2] && gamefield[y][x] == gamefield[y - 3][x + 3]) {
					return true;
				}
			}
		}
		return false;
	}
}
