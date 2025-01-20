package uebung_8_1;

public class Car extends Vehicle {

	private int doors;
	private int seats;

	public Car(String id, boolean isGasoline, Color color, int ps, int doors, int seats) {
		super(id, isGasoline, color, ps);
		this.doors = doors;
		this.seats = seats;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
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

		Car pkw = (Car) obj;

		if (this.doors != pkw.getDoors()) {
			return false;
		}

		if (this.seats != pkw.getSeats()) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "PKW: {anzahlTueren=" + doors + ", anzahlSitzplaetze=" + seats + "} " + super.toString();
	}
}
