package uebung_6_2;

public class Tree {
	private int age;
	private int height;

	public Tree(int age, int height) {
		this.age = age;
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// Method to harvest this tree
	public void harvest() {
		System.out.println("Sie haben nichts geerntet");
	}
}
