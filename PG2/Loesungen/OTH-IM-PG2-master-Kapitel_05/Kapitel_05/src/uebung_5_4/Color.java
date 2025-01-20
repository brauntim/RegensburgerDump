package uebung_5_4;

public class Color {

	private int red;
	private int green;
	private int blue;

	public Color() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	public int getRed() {
		return this.red;
	}

	public void setRed(int value) {
		this.red = value;
	}

	public int getGreen() {
		return this.green;
	}

	public void setGreen(int value) {
		this.green = value;
	}

	public int getBlue() {
		return this.blue;
	}

	public void setBlue(int value) {
		this.blue = value;
	}

	public String toString() {
		// format the string to the rgb color format
		return String.format("#%02X%02X%02X", getRed(), getGreen(), getBlue());
	}

}
