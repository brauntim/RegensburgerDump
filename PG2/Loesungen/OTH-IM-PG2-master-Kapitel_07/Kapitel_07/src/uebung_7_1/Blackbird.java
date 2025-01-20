package uebung_7_1;

public class Blackbird extends Bird implements ICanFly {

	public Blackbird(String name) {
		super(name);
	}

	@Override
	public void sing() {
		System.out.println("Die Drossel singt");
	}

	@Override
	public void fly() {
		System.out.println("Die Amsel fliegt");
	}

}
