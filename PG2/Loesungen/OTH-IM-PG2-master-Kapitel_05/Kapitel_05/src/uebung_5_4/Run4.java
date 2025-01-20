package uebung_5_4;

public class Run4 {

	public static void main(String[] args) {

		Article a1 = new Article();
		a1.setArticleNumber(2);

		Article a2 = new Article();
		a2.setArticleNumber(3);

		ShoppingCart cart = new ShoppingCart();
		cart.add(a1);
		cart.add(a2);

		cart.print();
		cart.remove(2);
		cart.print();
	}

}
