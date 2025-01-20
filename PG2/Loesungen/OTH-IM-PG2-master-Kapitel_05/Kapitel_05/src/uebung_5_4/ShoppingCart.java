package uebung_5_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

	// instance variables
	private List<Article> articles = new ArrayList<Article>();
	private int articleNumber = 1;

	// getter
	public int getSize() {
		return this.articles.size();
	}

	public List<Article> getArtList() {
		return this.articles;
	}

	public int getNewArtNr() {
		return this.articleNumber++;
	}

	// setter
	public void setArtList(List<Article> artList) {
		this.articles = artList;
	}

	// operations
	public void add(Article article) {
		if (article.getArticleNumber() == 0) {
			article.setArticleNumber(this.articleNumber++);
		}
		this.articles.add(article);
	}

	public boolean remove(int articleNumber) {
		Iterator<Article> iterator = this.articles.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getArticleNumber() == articleNumber) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Shopping Cart [articles=" + this.articles + "]";
	}

}
