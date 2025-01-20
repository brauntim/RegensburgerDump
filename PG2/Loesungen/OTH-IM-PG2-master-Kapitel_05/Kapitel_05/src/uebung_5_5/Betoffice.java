package uebung_5_5;

import java.util.ArrayList;
import java.util.List;

public class Betoffice {

	private final List<Bet> bets;
	private final List<Race> races;
	private static final int QUOTE = 2;

	public Betoffice() {
		this.bets = new ArrayList<Bet>();
		this.races = new ArrayList<Race>();
	}

	public void acceptBet(Bet bet) {
		if (bet.getRace().getStatus() == Status.WAITING) {
			this.bets.add(bet);
		}
	}

	public void addRace(Race race) {
		this.races.add(race);
	}

	public void start() {
		for (Race r : this.races) {
			if (r.getStatus() == Status.WAITING) {
				r.start();
			}
		}
	}

	public void calculateResults() {
		for (Bet b : this.bets) {
			if (b.getRace().getStatus() == Status.FINISHED) {
				b.setResult();
			}
		}
	}

	public static int getQuote() {
		return Betoffice.QUOTE;
	}

	@Override
	public String toString() {
		String result = "Wettergebnisse:\n";
		for (Bet b : this.bets) {
			result += b.toString() + "\n";
		}

		return result;
	}

}
