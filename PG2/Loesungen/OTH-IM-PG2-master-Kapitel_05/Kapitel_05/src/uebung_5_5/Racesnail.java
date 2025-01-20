package uebung_5_5;

import java.util.Random;

public class Racesnail implements Comparable<Racesnail> {

	private static Random r = new Random();

	private String name;
	private final int startnumber;
	private final int speed;
	private int placement;
	private int time;
	private int distance_traveled;

	public Racesnail(String name, int startnummer, int geschwindigkeit) {
		this.name = name;
		this.startnumber = startnummer;
		this.speed = geschwindigkeit;
		this.placement = 0;
		this.distance_traveled = 0;
	}

	// Setter

	public void setName(String name) {
		this.name = name;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	// Getter

	public String getName() {
		return this.name;
	}

	public int getStartnumber() {
		return this.startnumber;
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getPlacement() {
		return this.placement;
	}

	public int getTime() {
		return this.time;
	}

	public int getdistance_traveled() {
		return this.distance_traveled;
	}

	// operations

	public void crawl() {
		this.distance_traveled += r.nextInt(this.speed + 1);
		this.time++;
	}

	public void insZielKriechen(int strecke) {
		while (this.distance_traveled < strecke) {
			crawl();
		}
	}

	@Override
	public String toString() {
		return String.format("Platz %d, Startnummer: %d, Name: %s, Geschwindigkeit: %d, benoetigte Zeit: %d",
				this.placement, this.startnumber, this.name, this.speed, this.time);
	}

	@Override
	public int compareTo(Racesnail other) {
		// Aufsteigende Sortierung 1..9 auf Grund der Zeit
		return this.time - other.getTime();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Racesnail)) {
			return false;
		}

		Racesnail other = (Racesnail) o;
		if (other.getStartnumber() != this.getStartnumber()) {
			return false;
		}

		return true;
	}

}
