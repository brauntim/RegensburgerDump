package uebung_5_2;

import java.util.Arrays;

public class FruitTree {
	double height;
	int age;
	int waterAmount;
	Branch[] branches = new Branch[5];
	Root[] roots = new Root[5];

	public FruitTree(double height, int age, int waterAmount) {
		this.height = height;
		this.age = age;
		this.waterAmount = waterAmount;
		for (int i = 0; i < branches.length; i++) {
			Branch newBranch = new Branch(60);
			branches[i] = newBranch;
		}

		for (int i = 0; i < roots.length; i++) {
			roots[i] = new Root(4.5);
		}
	}

	public static void main(String[] args) {
		FruitTree fruitTree = new FruitTree(10.0, 5, 30);
		fruitTree.growBranches();
		fruitTree.ripeFruits();
		fruitTree.changeLeafColor("gelb");
		fruitTree.printTree();
	}

	public void receiveWater() {
		for (int i = 0; i < roots.length; i++) {
			waterAmount += roots[i].deliverWater();
		}
		System.out.printf("Der Baum verfuegt über %d Einheiten Wasser\n", waterAmount);
	}

	public void growBranches() {
		if (waterAmount >= 5) {
			for (int i = 0; i < branches.length; i++) {
				branches[i].grow();
			}
			waterAmount -= 5;
			System.out.printf("Alle Aeste sind um %.2f Meter gewachsen\n", 1.0);
		}
		else {
			System.out.println("Nicht genuegend Wasser vorhanden");
		}
	}

	public void ripeFruits() {
		if (waterAmount >= 5) {
			for (int i = 0; i < branches.length; i++) {
				for (int j = 0; j < branches[i].getFruits().length; j++) {
					branches[i].getFruits()[j].ripe();
				}
			}
			waterAmount -= 5;
			System.out.println("Alle Fruechte sind gereift");
		}
		else {
			System.out.println("Nicht genuegend Wasser vorhanden");
		}
	}

	public void changeLeafColor(String color) {
		if (waterAmount >= 5) {
			for (int i = 0; i < branches.length; i++) {
				for (int j = 0; j < branches[i].getLeafs().length; j++) {
					branches[i].getLeafs()[j].changeColor(color);
				}
			}
			waterAmount -= 5;
			System.out.println("Alle Blaetter haben die Farbe gewechselt");
		}
		else {
			System.out.println("Nicht genuegend Wasser vorhanden");
		}
	}

	public void printTree() {
		System.out.printf(
				"Dieser Baum ist %.2f Meter hoch, %d Jahre alt, %d Wasserreserven und folgende Bestandteile:\n", height,
				age, waterAmount);
		for (int i = 0; i < branches.length; i++) {
			System.out.println(branches[i]);
		}
		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i]);
		}
	}

	public double getHeight() {
		return height;
	}

	public int getAge() {
		return age;
	}

	public int getWaterAmount() {
		return waterAmount;
	}

	public Branch[] getBranches() {
		return branches;
	}

	public Root[] getRoots() {
		return roots;
	}

}
