package uebung_6_5;

public class Person {

	private String firstName;
	private String lastName;

	public Person() {
		System.out.println("Create new person");
	}

	public Person(String firstName) {
		this.firstName = firstName;
		System.out.println("Create Person: " + firstName);
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Create Person: " + firstName + " " + lastName);
	}

	@Override
	public String toString() {
		return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName + "]";
	}
}
