package uebung_7_3;

public class MainProgram {

	public static void main(String[] args) {
		ShoppinCart warenkorb1 = new ShoppinCart();

		Luxuryarticle lArtikel1 = new Luxuryarticle();
		lArtikel1.setName("Luxusartikel1");
		lArtikel1.setPrice(600.99);

		Luxuryarticle lArtikel2 = new Luxuryarticle();
		lArtikel2.setName("Luxusartikel2");
		lArtikel2.setPrice(1000.99);

		Ornament schmuck1 = new Ornament();
		schmuck1.setName("Schmuck");
		schmuck1.setPrice(455.55);

		Book buch = new Book();
		buch.setName("Buch1");
		buch.setPrice(10.79);
		buch.setAuthor("Tutor");

		warenkorb1.add(lArtikel1);
		warenkorb1.add(lArtikel2);
		warenkorb1.add(schmuck1);
		warenkorb1.add(buch);

		warenkorb1.print();

		System.out.println("Gesamtpreis: " + warenkorb1.gesamtPreis());
	}
}
