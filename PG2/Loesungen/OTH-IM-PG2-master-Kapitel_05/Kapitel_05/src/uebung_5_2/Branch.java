package uebung_5_2;

import java.util.Arrays;

public class Branch {
	double length = 10.0;
	Leaf[] leafs = new Leaf[5];
	Fruit[] fruits = new Fruit[5];

	public Branch(double length) {
		this.length = length;
		for (int i = 0; i < leafs.length; i++) {
			leafs[i] = new Leaf("gruen");
		}

		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new Fruit();
		}
	}

	public void grow() {
		this.length += 1;
	}

	public double getLength() {
		return length;
	}

	public Leaf[] getLeafs() {
		return leafs;
	}

	public Fruit[] getFruits() {
		return fruits;
	}

	public String toString() {
		return "Dieser Ast hat " + leafs.length + " Blaetter und " + fruits.length + " Fruechte"
				+ Arrays.toString(leafs) + Arrays.toString(fruits);
	}

}
