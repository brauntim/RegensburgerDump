package uebung_8_1;

public class Truck extends Vehicle {

	private int tireCount;
	private int loadingWeight;

	public Truck(String id, boolean isGasoline, Color color, int ps, int tireCount, int loadingWeight) {
		super(id, isGasoline, color, ps);
		this.tireCount = tireCount;
		this.loadingWeight = loadingWeight;
	}

	public int getTireCount() {
		return tireCount;
	}

	public void setTireCount(int tireCount) {
		this.tireCount = tireCount;
	}

	public int getLoadingWeight() {
		return loadingWeight;
	}

	public void setLoadingWeight(int loadingWeight) {
		this.loadingWeight = loadingWeight;
	}

	// The overridden equals(). If the super-class-method already returns false, no
	// more checks needed to return false. If
	// not an instance of this class, return false. Otherwise cast and check
	// attributes.
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Truck truck = (Truck) obj;

		if (this.tireCount != truck.getTireCount())
			return false;
		if (this.loadingWeight != truck.getLoadingWeight())
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "LKW: {anzahlReifen=" + tireCount + ", ladeGewicht=" + loadingWeight + "} " + super.toString();
	}
}
