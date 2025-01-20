package uebung_5_1;

public class Trailer {
	private String mark;
	private int maxSpeed;
	private Motorcycle motorcycle;

	public Trailer(String mark, int maxSpeed) {
		this.mark = mark;
		this.maxSpeed = maxSpeed;
		this.motorcycle = null;
	}

	public void attachLoad(Motorcycle motorcycle) {
		this.motorcycle = motorcycle;
	}

	public Motorcycle detachLoad() {
		Motorcycle temp = this.motorcycle;
		this.motorcycle = null;
		return temp;
	}

	public boolean isLoaded() {
		if (motorcycle != null) {
			return true;
		}
		return false;
	}

	public String getMark() {
		return mark;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	@Override
	public String toString() {
		return "Trailer [mark=" + mark + ", maxSpeed=" + maxSpeed + ", motorcycle=" + motorcycle + "]";
	}
}
