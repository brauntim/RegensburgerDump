package uebung_5_4;

public class Article {

	public int articleNumber;
	public String description;
	public Color color;
	public Price price;

	public Article() {
		this.articleNumber = 0;
		this.description = "";
		this.price = new Price();
		this.color = new Color();
	}

	public int getArticleNumber() {
		return this.articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String toString() {
		return "\n Articlenumber: " + getArticleNumber() + "\n Description: " + getDescription() + "\n Price: "
				+ getPrice() + "\n Color: " + getColor().toString();
	}

}
