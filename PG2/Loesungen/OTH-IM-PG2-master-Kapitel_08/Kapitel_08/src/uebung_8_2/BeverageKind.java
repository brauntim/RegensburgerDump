package uebung_8_2;

// This enum looks different from others used so far. See the link below for documentation
// https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

public enum BeverageKind { // Sorte des Getränks

	COLA(1, "Cola", 80), LEMONADE(2, "Limo", 70), WATER(3, "Wasser", 60);

	private final int identifier;
	private final String description;
	private final int priceInEuroCents;

	// No public modifier at this point allowed
	private BeverageKind(int identifier, String description, int priceInEuroCents) {
		this.identifier = identifier;
		this.description = description;
		this.priceInEuroCents = priceInEuroCents;
	}

	public int getIdentifier() {
		return this.identifier;
	}

	public String getDescription() {
		return this.description;
	}

	public int getPriceInEuroCents() {
		return this.priceInEuroCents;
	}

	public String toString() {
		return getIdentifier() + ": " + getDescription() + " [" + getPriceInEuroCents() + " Cent]";
	}
}
