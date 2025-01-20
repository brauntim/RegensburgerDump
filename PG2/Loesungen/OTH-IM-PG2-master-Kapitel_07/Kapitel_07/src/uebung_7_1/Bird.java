package uebung_7_1;

public abstract class Bird implements IHasName {

	public abstract void sing();

	public Bird(String name) {
		this.name = name;
	}

	public String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return IHasName.sayHello + " " + this.getClass().getSimpleName() + " " + this.name;
	}
}
