package uebung_8_2;

public class Bottle {

	private BeverageKind beverageKind;

	public Bottle(BeverageKind beverageKind) {
		this.beverageKind = beverageKind;
	}

	public BeverageKind getBeverageKind() {
		return this.beverageKind;
	}

	public String toString() {
		return getBeverageKind().getDescription() + "-Flasche@" + this.hashCode();
	}
}
