package uebung_6_2;

public class Rectangle {

	private double width;
	private double height;

	/**
	 * Constructor
	 * 
	 * @param lenght
	 * @param width
	 */
	public Rectangle(double witdh, double height) {
		this.width = witdh;
		this.height = height;
	}

	/**
	 * Calculates the scope of the rectangle
	 * 
	 * @return scope of this rectangle
	 */
	public double calculateScope() {
		return 2 * this.width + 2 * this.height;
	}

	/**
	 * Calculates the area of this rectangle
	 * 
	 * @return area of this rectangle
	 */
	public double calculateArea() {
		return this.width * this.height;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
