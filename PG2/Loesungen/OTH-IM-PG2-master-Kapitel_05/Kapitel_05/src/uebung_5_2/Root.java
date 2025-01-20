package uebung_5_2;

public class Root {
	double depth;

	public Root(double depth) {
		this.depth = depth;
	}

	public int deliverWater() {
		return 1;
	}

	public double getDepth() {
		return depth;
	}

	public String toString() {
		return "Diese Wurzel ist " + depth + " Meter tief";
	}
}
