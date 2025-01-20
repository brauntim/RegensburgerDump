package uebung_9_4;

public class Drink {
	// perfect temperature for a cold drink
	private int perfectTemperature;
	// current temperature for a drink
	private int currentTemperature;

	public Drink(int currentTemperature, int perfectTemperature) {
		this.currentTemperature = currentTemperature;
		this.perfectTemperature = perfectTemperature;
	}

	public int getCurrentTemperature() {
		return this.currentTemperature;
	}

	public int getPerfektTemperature() {
		return this.perfectTemperature;
	}

}
