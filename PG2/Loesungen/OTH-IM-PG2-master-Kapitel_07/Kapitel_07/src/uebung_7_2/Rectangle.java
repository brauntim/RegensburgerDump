package uebung_7_2;

public class Rectangle extends GeoObject {

	private double width;
	private double height;

	/**
	 * Constructor
	 * 
	 * @param lenght
	 * @param width
	 */
	public Rectangle(double x, double y, double width, double height) {
		// Ruft Konstruktor von Quadrat auf
		super(x, y);
		this.width = width;
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
