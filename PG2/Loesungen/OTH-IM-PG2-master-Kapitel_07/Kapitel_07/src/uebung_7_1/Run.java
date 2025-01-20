package uebung_7_1;

import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		List<Bird> birds = new ArrayList<>();

		birds.add(new Songthrush("Peter"));
		birds.add(new Blackbird("Franz"));
		birds.add(new Penguin("Sophie"));

		for (Bird bird : birds) {
			System.out.println(bird.getName());
		}
	}
}
