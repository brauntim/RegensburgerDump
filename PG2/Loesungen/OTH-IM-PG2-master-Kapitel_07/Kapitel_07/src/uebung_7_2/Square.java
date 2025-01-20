package uebung_7_2;

public class Square extends Rectangle {

	/**
	 * Constructor
	 * 
	 * @param length
	 */
	public Square(double x, double y, double length) {
		super(x, y, length, length);
	}

	public void setLength(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	public double getLength() {
		return super.getWidth();
	}

	// Overriding the Method, because all sides of a square are equal
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	// Overriding the Method, because all sides of a square are equal
	@Override
	public void setHeight(double height) {
		super.setWidth(height);
		super.setHeight(height);
	}

}
