package uebung_7_3;

public class Ornament extends Luxuryarticle {

	@Override
	public double bruttoPrice() {
		return this.getPrice() * this.getTax() + (this.getPrice() * 1.3);
	}

	@Override
	public String toString() {
		return "Schmuck [name=" + this.getName() + ", preis=" + this.getPrice() + "]";
	}
}
