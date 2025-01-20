package uebung_5_1;

public class Motorcycle {
	private String mark;
	private int engineDisplacement;

	public Motorcycle(String mark, int engineDisplacement) {
		this.mark = mark;
		this.engineDisplacement = engineDisplacement;
	}

	public String getMark() {
		return mark;
	}

	public int getEngineDisplacement() {
		return engineDisplacement;
	}

	@Override
	public String toString() {
		return "Motorcycle [mark=" + mark + ", engineDisplacement=" + engineDisplacement + "]";
	}
}
