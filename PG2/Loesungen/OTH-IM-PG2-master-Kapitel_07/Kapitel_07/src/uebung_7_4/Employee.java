package uebung_7_4;

public class Employee {
	String lastName;
	String firstName;
	Job job;

	public Employee(String lastName, String firstName, Job job) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", job=" + job + "]";
	}
}
