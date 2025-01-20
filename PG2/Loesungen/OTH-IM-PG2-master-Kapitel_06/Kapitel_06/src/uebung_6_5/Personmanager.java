package uebung_6_5;

import java.util.ArrayList;
import java.util.List;

public class Personmanager {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();

		personList.add(new Person());
		personList.add(new Person("Tobias"));
		personList.add(new Person("Tobias", "Graml"));

		for (Person person : personList) {
			System.out.println(person);
		}
	}

}
