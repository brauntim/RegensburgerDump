package uebung_7_3;

public class Luxuryarticle implements Product {

	private String name;
	private double price;
	private double tax = 1.25;

	@Override
	public double bruttoPrice() {
		return this.price * this.tax;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return this.tax;
	}

	@Override
	public String toString() {
		return "Luxusartikel [name=" + this.name + ", preis=" + this.price + "]";
	}

}
