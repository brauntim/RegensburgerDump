package uebung_5_2;

public class Fruit {
	double weight = 50.0;
	boolean isRipe = false;

	public void ripe() {
		this.isRipe = true;
	}

	public boolean isRipe() {
		return isRipe;
	}

	@Override
	public String toString() {
		return "Diese Frucht wiegt " + weight + ". Reif: " + isRipe;
	}
}
