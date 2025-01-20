package uebung_6_2;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a new square
		Square s = new Square(10.5);

		System.out.println("Breite des Quadrats: " + s.getWidth());
		System.out.println("Hoehe des Quadrats: " + s.getHeight());
		System.out.println("Flaeche des Quadrats: " + s.calculateArea());
		System.out.println("Umfang des Quadrats: " + s.calculateScope());

		// Create a new rectangle
		Rectangle r = new Rectangle(10.5, 5.5);

		System.out.println("Breite des Rechtecks: " + r.getWidth());
		System.out.println("Hoehe des Rechtecks: " + r.getHeight());
		System.out.println("Flaeche des Quadrats: " + r.calculateArea());
		System.out.println("Umfang des Quadrats: " + r.calculateScope());

		System.out.println();

		Tree tree1 = new Tree(15, 7);
		System.out.println("Alter des Baums: " + tree1.getAge());
		System.out.println("Hoehe des Baums: " + tree1.getAge());
		tree1.harvest();

		Tree tree2 = new FruitTree(10, 5, "Aepfel");
		System.out.println("Alter des Baums: " + tree2.getAge());
		System.out.println("Hoehe des Baums: " + tree2.getAge());
		tree2.harvest();
	}

}
