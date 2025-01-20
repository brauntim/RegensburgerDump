package uebung_5_4;

import java.util.List;
import java.util.Scanner;

public class Run3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MainHelper helper = new MainHelper(sc);
		List<Article> articles = helper.initializeArticles();
		boolean found = false;

		double price = 100;

		for (Article article : articles) {
			if (article.getPrice().getValue() > price) {
				System.out.println(article);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No articles found");
		}
		sc.close();
	}

}
