package uebung_5_1;

public class Car {
	private String brand;
	private String color;
	private double weight;
	private String mark;
	private Trailer trailer;

	public Car(String brand, String color, double weight, String mark) {
		this.brand = brand;
		this.color = color;
		this.weight = weight;
		this.mark = mark;
		this.trailer = null;
	}

	public void attachTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Trailer detachTrailer() {
		Trailer temp = this.trailer;
		this.trailer = null;
		return temp;
	}

	public boolean isTrailerAttached() {
		if (trailer != null) {
			return true;
		}
		return false;
	}

	public boolean isTrailerLoaded() {
		if (trailer != null) {
			return trailer.isLoaded();
		}
		return false;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public double getWeight() {
		return weight;
	}

	public String getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", weight=" + weight + ", mark=" + mark + ", trailer="
				+ trailer + "]";
	}
}
