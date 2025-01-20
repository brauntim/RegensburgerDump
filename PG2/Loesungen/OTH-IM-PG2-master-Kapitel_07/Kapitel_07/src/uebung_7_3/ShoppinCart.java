package uebung_7_3;

import java.util.ArrayList;
import java.util.List;

public class ShoppinCart {

	private List<Product> products = new ArrayList<>();

	public void print() {
		for (Product product : this.products) {
			System.out.println(product.toString());
		}
	}

	public void clear() {
		products.clear();
	}

	public void add(Product article) {
		products.add(article);
	}

	public double gesamtPreis() {
		double sum = 0;
		for (Product produkt : products) {
			sum += produkt.bruttoPrice();
		}
		return sum;
	}

}
