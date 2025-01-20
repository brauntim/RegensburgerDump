package uebung_5_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

	private final List<Racesnail> participants;
	private final String name;
	private Status status;
	private int distance;

	public Race(String name, int distance) {
		this.participants = new ArrayList<Racesnail>();
		this.name = name;
		this.status = Status.WAITING;
		this.distance = distance;
	}

	// Getter

	public List<Racesnail> getParticipants() {
		return this.participants;
	}

	public String getName() {
		return this.name;
	}

	public Status getStatus() {
		return this.status;
	}

	public int getDistance() {
		return this.distance;
	}

	// Setter

	public void setDistance(int distance) {
		if (this.status == Status.WAITING) {
			this.distance = distance;
		}
	}

	public void addSnail(Racesnail snail) {
		if (this.status == Status.WAITING && !this.participants.contains(snail)) {
			this.participants.add(snail);
		}
	}

	public void removeSnail(Racesnail snail) {
		if (this.status == Status.WAITING) {
			this.participants.remove(snail);
		}
	}

	public void start() {
		this.status = Status.RUNNING;
		boolean goOn = true;

		while (goOn) {
			goOn = false;
			for (Racesnail r : this.participants) {
				if (r.getdistance_traveled() < this.distance) {
					r.crawl();
					goOn = true;
				}
			}
		}

		// Alternative Loesung zur "while"-Schleife
		// for (Rennschnecke r : teilnehmer) {
		// r.insZielKriechen(strecke);
		// }

		Collections.sort(this.participants);
		for (int i = 0; i < this.participants.size(); i++) {
			this.participants.get(i).setPlacement(i + 1);
		}

		this.status = Status.FINISHED;
	}

	@Override
	public String toString() {
		String ret = String.format("Ergebnisse fuer Rennen %s, zurueckzulegende Strecke: %d :\n--- Status: %s\n",
				this.name, this.distance, this.status);

		for (Racesnail r : this.participants) {
			ret += r.toString() + "\n";
		}

		return ret;
	}

}