package uebung_5_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelper {
	private Scanner scanner;

	public MainHelper(Scanner scanner) {
		this.scanner = scanner;
	}

	/*
	 * Ask the user to enter all articles.
	 */
	public List<Article> initializeArticles() {
		boolean oneMore = true;
		List<Article> articles = new ArrayList<Article>();

		while (oneMore) {
			articles.add(getArticle(scanner));
			System.out.print("\nWeiteren Artikel einlesen? (0/1)");
			oneMore = scanner.nextInt() == 1;
			scanner.nextLine();
		}
		return articles;
	}

	/*
	 * Ask user to enter one specific article
	 */
	public Article getArticle(Scanner scanner) {
		Article ret = new Article();

		System.out.println("Neuer Artikel:");
		System.out.print("Artikelnummer: ");
		ret.setArticleNumber(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Beschreibung: ");
		ret.setDescription(scanner.nextLine());

		System.out.print("Preis: ");
		ret.getPrice().setValue(scanner.nextDouble());
		scanner.nextLine();

		System.out.print("Waehrung: ");
		ret.getPrice().setCurrency(scanner.nextLine());

		System.out.print("Farbe (rot-Komponente): ");
		ret.getColor().setRed(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Farbe (gruen-Komponente): ");
		ret.getColor().setGreen(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Farbe (blau-Komponente): ");
		ret.getColor().setBlue(scanner.nextInt());
		scanner.nextLine();

		return ret;
	}

}
