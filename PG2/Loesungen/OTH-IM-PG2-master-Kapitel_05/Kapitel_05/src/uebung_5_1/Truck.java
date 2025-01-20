package uebung_5_1;

public class Truck {
	private String mark;
	private int maxLoad;
	private Car load;

	public Truck(String mark, int maxLoad) {
		this.mark = mark;
		this.maxLoad = maxLoad;
		this.load = null;
	}

	public String getMark() {
		return mark;
	}

	public int getMaxLoad() {
		return maxLoad;
	}

	public void loadCar(Car car) {
		if (!car.isTrailerAttached()) {
			if (car.getWeight() <= this.maxLoad) {
				this.load = car;
				System.out.println("Auto eingeladen");
			}
			else {
				System.out.println("Auto zu schwer");
			}
		}
		else {
			System.out.println("Auto hat Anhaenger angehaengt und kann nicht verladen werden");
		}
	}
	
	public Car unloadCar() {
		Car temp = this.load;
		this.load = null;
		return temp;
	}

	public boolean isLoaded() {
		if (load != null) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Truck [mark=" + mark + ", maxLoad=" + maxLoad + ", load=" + load + "]";
	}
}
