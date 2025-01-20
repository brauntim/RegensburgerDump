package uebung_7_3;

public class Book implements Product {

	private String name;
	private String author;
	private double price;
	private double tax = 1.05;

	@Override
	public double bruttoPrice() {
		return this.price * this.tax;
	}

	@Override
	public String toString() {
		return "Buch [name=" + this.name + ", author=" + this.author + ", preis=" + this.price + "]";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
}
