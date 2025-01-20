package uebung_7_1;

public class Songthrush extends Bird implements ICanFly {

	public Songthrush(String name) {
		super(name);
	}

	@Override
	public void sing() {
		System.out.println("Die Drossel singt");
	}

	@Override
	public void fly() {
		System.out.println("Die Drossel fliegt");
	}

}
