package uebung_8_3.shallow_copy;

public class Main {

	public static void main(String[] args) {

		Department department1 = new Department(1, "Entwicklung");

		Employee employee1 = new Employee(1, "Hans", department1);
		Employee employee2 = employee1.clone();

		System.out.println(employee1);
		System.out.println(employee2);

		department1.setName("Marketing");

		System.out.println(employee1);
		System.out.println(employee2);

	}

}
