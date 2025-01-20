package uebung_5_4;

public class Price {

	private double value;
	private String currency;

	public Price() {
		this.value = 0.0;
		this.currency = "Euro";
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String value) {
		this.currency = value;
	}

	/*
	 * #learnmore why are we using @Override here? the function 'toString()' is
	 * defined as a Java function, however we want to use it in another way. When
	 * calling 'toString()' for a Price, we want to get the value and the currency,
	 * that's why we 'override' it.
	 * 
	 * you've probably heard about 'override' and 'overload' -- do you know what the
	 * difference is? (important for your exam!)
	 */
	@Override
	public String toString() {
		return String.format("%.2f", getValue()) + " " + getCurrency();
	}

}
