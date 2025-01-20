package uebung_5_5;

public class Programm {
	public static void main(String[] args) {
		// creating snails
		Racesnail rs1 = new Racesnail("Rennschnecke 1", 1, 11);
		Racesnail rs2 = new Racesnail("Rennschnecke 2", 2, 15);
		Racesnail rs3 = new Racesnail("Rennschnecke 3", 3, 14);
		Racesnail rs4 = new Racesnail("Rennschnecke 4", 4, 11);
		Racesnail rs5 = new Racesnail("Rennschnecke 5", 5, 12);
		Racesnail rs6 = new Racesnail("Rennschnecke 6", 6, 14);

		// creating a race
		Race r1 = new Race("Rennen 1", 200);
		r1.addSnail(rs1);
		r1.addSnail(rs2);
		r1.addSnail(rs3);
		r1.addSnail(rs4);
		r1.addSnail(rs5);
		r1.addSnail(rs6);

		// the bet-office organizes all races
		Betoffice w = new Betoffice();
		w.addRace(r1);

		// create bets
		Bet w1 = new Bet("Spieler 1", r1, rs1, 100);
		Bet w2 = new Bet("Spieler 2", r1, rs2, 50);
		Bet w3 = new Bet("Spieler 3", r1, rs5, 130);

		// tell the bets to the bet-office
		w.acceptBet(w1);
		w.acceptBet(w2);
		w.acceptBet(w3);

		// start the races
		w.start();

		// read the results
		w.calculateResults();

		// output...
		System.out.println(r1);
		System.out.println(w);
	}
}
