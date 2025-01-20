package uebung_8_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainProgramm {

	public static void main(String[] args) {

		Job job1 = new Job("gutBezahlterJob", 5000);
		Job job2 = new Job("schlechtBezahlterJob", 2000);

		Person p1 = new Person("P1", 180, job1);
		Person p2 = new Person("P2", 185, job2);
		Person p3 = new Person("P3", 181, job1);

		List<Person> list = new ArrayList<Person>();

		System.out.println("Unsortiert: ");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p1);
		for (Person p : list) {
			System.out.println(p.getName() + " - Gehalt:" + p.getJob().getSalary() + " - Size: " + p.getSize());
		}

		Collections.sort(list);

		System.out.println("Sortiert: ");
		for (Person p : list) {
			System.out.println(p.getName() + " - Gehalt:" + p.getJob().getSalary() + " - Size: " + p.getSize());
		}

	}

}
