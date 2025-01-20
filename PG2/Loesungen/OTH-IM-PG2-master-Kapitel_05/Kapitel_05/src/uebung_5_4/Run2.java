package uebung_5_4;

import java.util.List;
import java.util.Scanner;

public class Run2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MainHelper helper = new MainHelper(sc);
		List<Article> articles = helper.initializeArticles();
		System.out.println("Bitte zu suchendende Artikelnummer eingeben:");

		int searchAricleNumber = sc.nextInt();

		boolean found = false;
		for (Article article : articles) {
			if (article.getArticleNumber() == searchAricleNumber) {
				System.out.println(article);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No article found");
		}

		sc.close();
	}

}
