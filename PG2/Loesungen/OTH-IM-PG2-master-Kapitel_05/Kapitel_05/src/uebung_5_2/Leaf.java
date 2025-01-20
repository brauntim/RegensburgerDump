package uebung_5_2;

public class Leaf {
	String color;

	public Leaf(String color) {
		this.color = color;
	}

	public void changeColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public String toString() {
		return "Dieses Blatt ist " + color;
	}

}
