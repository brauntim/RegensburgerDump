package uebung_7_1;

public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
	}

	@Override
	public void sing() {
		System.out.println("Der Pinguin schnattert");
	}
}
