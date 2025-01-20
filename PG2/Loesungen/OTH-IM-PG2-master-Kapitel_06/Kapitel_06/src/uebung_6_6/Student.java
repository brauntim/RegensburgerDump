package uebung_6_6;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private static int static_id = 1;

	// Constructor for Student (empty but initializing variables)
	public Student() {
		// general initializing
		this.firstName = "";
		this.lastName = "";
		this.id = Student.static_id;

		// adding a 1 to the static id
		Student.static_id++;
	}

	// getter and setter
	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
