package uebung_3_06;

import java.util.Arrays;
import java.util.Scanner;

public class GradeList {
	public static void main(String[] args) {
		String[][] students = new String[0][2]; // Array for students and their grades. Each Row one student with his
												// grade

		Scanner sc = new Scanner(System.in);

		System.out.print("Weiteren Studenten erfassen (0/1)? ");
		while (sc.nextInt() == 1) {
			// needs to be put after each sc.nextInt() or similar because these methods do
			// not read the \n
			sc.nextLine();

			// Extending the array by one for the new student
			students = Arrays.copyOf(students, students.length + 1);
			students[students.length - 1] = new String[2];

			System.out.print("Name: ");
			students[students.length - 1][0] = sc.nextLine();

			System.out.print("Note: ");
			int grade = 0;
			while ((grade = sc.nextInt()) < 1 && grade > 6) {
				System.out.println("Bitte eine Note im Bereich zwischen 1 und 6 eingeben.");
			}
			sc.nextLine();
			students[students.length - 1][1] = Integer.toString(grade);
			System.out.print("Weiteren Studenten erfassen (0/1)? ");
		}
		sc.close();

		// output
		for (int i = 0; i < students.length; i++) {
			System.out.println(String.format("%d. %s: %d", i + 1, students[i][0], Integer.parseInt(students[i][1])));
		}
	}
}
