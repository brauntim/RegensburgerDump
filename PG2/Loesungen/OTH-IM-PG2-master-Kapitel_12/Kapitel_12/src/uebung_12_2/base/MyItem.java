package uebung_12_2.base;

//This class represents an item, that can be stored in the storage
public class MyItem {
	private int id;
	private String name;

	public MyItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", ID" + id;
	}

}
