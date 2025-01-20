package uebung_6_1;

public abstract class FieldObject {

	private char symbol;

	public FieldObject(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
