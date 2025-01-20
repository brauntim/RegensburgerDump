package uebung_5_4;

import java.util.List;
import java.util.Scanner;

public class Run1 {

	public static void main(String[] args) {
		// we will use initializeArticles in other functions, that is why
		// you can look it up in MainHelper
		Scanner scanner = new Scanner(System.in);
		MainHelper helper = new MainHelper(scanner);
		List<Article> articles = helper.initializeArticles();

		for (Article article : articles) {
			System.out.println(article);
		}
	}

}
