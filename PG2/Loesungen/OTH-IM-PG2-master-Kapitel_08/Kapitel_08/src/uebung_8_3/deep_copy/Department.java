package uebung_8_3.deep_copy;

public class Department implements Cloneable {
	private int id;
	private String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + ": Department [id=" + id + ", name=" + name + "]";
	}

	@Override
	public Department clone() {
		try {
			return (Department) super.clone();
		}
		catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
