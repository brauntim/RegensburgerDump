package uebung_6_2;

public class FruitTree extends Tree {

	private String fruits;

	public FruitTree(int age, int height, String fruits) {
		// calling the super-class constructor for age and height
		super(age, height);
		this.fruits = fruits;
	}

	// Overriding Method harvest() in Tree
	@Override
	public void harvest() {
		System.out.println("Sie haben " + fruits + " geerntet");
	}

}
