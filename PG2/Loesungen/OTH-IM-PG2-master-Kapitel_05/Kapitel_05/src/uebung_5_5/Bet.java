package uebung_5_5;

public class Bet {

	private String player;
	private Race race;
	private Racesnail snail;
	private int wager;
	private boolean win;
	private int profit;

	public Bet(String spieler, Race rennen, Racesnail schnecke, int einsatz) {
		this.player = spieler;
		this.race = rennen;
		this.snail = schnecke;
		this.wager = einsatz;
		this.win = false;
		this.profit = 0;
	}

	// Getter
	public String getPlayer() {
		return this.player;
	}

	public Race getRace() {
		return this.race;
	}

	public Racesnail getSnail() {
		return this.snail;
	}

	public int getWager() {
		return this.wager;
	}

	public boolean isWin() {
		return this.win;
	}

	// Setter
	public void setPlayer(String player) {
		this.player = player;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setSnail(Racesnail snail) {
		this.snail = snail;
	}

	public void setWager(int wager) {
		this.wager = wager;
	}

	public void setResult() {
		this.win = this.race.getParticipants().get(0).equals(this.snail);
		if (this.win) {
			this.profit = this.wager * Betoffice.getQuote();
		}
	}

	@Override
	public String toString() {
		if (this.race.getStatus() == Status.FINISHED) {
			return String.format("Wette von Spieler %s fuer Rennen %s auf Rennschnecke #%d, Gewonnen %s, Gewinn: %d",
					this.player, this.race.getName(), this.snail.getStartnumber(), (this.win ? "ja" : "nein"),
					this.profit);
		}
		else {
			return String.format("Wette von Spieler %s, Rennen %s ist noch nicht beendet", this.player,
					this.race.getName());
		}
	}
}
