package uebung_5_3;

public class Class {

	private String name;
	private int credits;
	private int multiplier;
	private double grade;

	public Class(String name, int credits, int multiplier) {
		this.name = name;
		this.credits = credits;
		this.multiplier = multiplier;
		this.grade = 0.0;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public String toString() {
		return "Class [name=" + name + ", credits=" + credits + ", multiplier=" + multiplier + ", grade=" + grade + "]";
	}
}
