package uebung_5_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
	private String name;
	private List<Student> students;
	private List<Course> courses;

	public static void main(String[] args) {
		University university = new University();
	}

	public University() {
		students = new ArrayList<>();
		courses = new ArrayList<>();
		initCourses();
		mainProgramm();
	}

	public void initCourses() {
		Course course = new Course("Wirtschaftsinformatik (Bachelor)");
		course.addClass("Programmieren 1", 6, 3);
		course.addClass("Programmieren 2", 6, 3);
		course.addClass("BWL 1", 6, 3);
		course.addClass("BWL 3", 6, 3);
		courses.add(course);

		course = new Course("Wirtschaftsinformatik (Master)");
		course.addClass("Moderne Datenbankkonzepte", 5, 3);
		course.addClass("Business Consulting", 5, 3);
		courses.add(course);

		course = new Course("Allgemeine Informatik (Bachelor)");
		course.addClass("Programmieren 1", 6, 3);
		course.addClass("Programmieren 2", 6, 3);
		courses.add(course);
	}

	public void mainProgramm() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		printMainMenu();
		while ((choice = scanner.nextInt()) != 5) {
			scanner.nextLine();
			switch (choice) {
			case 1:
				addStudent(scanner);
				break;
			case 2:
				editStudent(scanner);
				break;
			case 3:
				printStudent(scanner);
				break;
			case 4:
				printAllStudents(scanner);
				break;

			default:
				break;
			}
			printMainMenu();
		}
		scanner.close();
	}

	public void printMainMenu() {
		System.out.println("Was moechten Sie tun?");
		System.out.println("1 - Student hinzufuegen");
		System.out.println("2 - Studentendaten bearbeiten");
		System.out.println("3 - Daten eines Studenten ausgeben");
		System.out.println("4 - Alle Studenten ausgeben");
		System.out.println("5 - Beenden");
	}

	public void printAllStudents(Scanner scanner) {
		for (int i = 0; i < students.size(); i++) {
			System.out.println((i + 1) + ": " + students.get(i));
		}
	}

	public void printStudent(Scanner scanner) {
		int index = 0;
		for (int i = 0; i < students.size(); i++) {
			System.out.println((i + 1) + ": " + students.get(i).getId());
		}
		System.out.println("Welcher Student?");
		while ((index = scanner.nextInt()) < 1 || index > students.size()) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Welcher Student?");
		}
		scanner.nextLine();
		System.out.println(students.get(index - 1).getDetailInformation());
	}

	public void editStudent(Scanner scanner) {
		int index = 0;
		for (int i = 0; i < students.size(); i++) {
			System.out.println((i + 1) + ": " + students.get(i).getId());
		}
		System.out.println("Welcher Student?");
		while ((index = scanner.nextInt()) < 1 || index > students.size()) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Welcher Student?");
		}
		scanner.nextLine();
		index--;

		System.out.println("Was moechten Sie tun?");
		System.out.println("1 - Nachname aendern");
		System.out.println("2 - Vorname aendern");
		System.out.println("3 - E-Mail aendern");
		System.out.println("4 - Note eintragen");
		System.out.println("5 - zurueck");

		int choice = 0;
		while ((choice = scanner.nextInt()) != 5) {
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Eingabe machen: ");
				students.get(index).setLastName(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 2:
				System.out.println("Eingabe machen: ");
				students.get(index).setFirstName(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 3:
				System.out.println("Eingabe machen: ");
				students.get(index).seteMail(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 4:
				editGrade(scanner, index);
				break;

			default:
				break;
			}
			System.out.println("Was moechten Sie tun?");
			System.out.println("1 - Nachname aendern");
			System.out.println("2 - Vorname aendern");
			System.out.println("3 - E-Mail aendern");
			System.out.println("4 - Note eintragen");
			System.out.println("5 - zurueck");
		}
	}

	public void editGrade(Scanner scanner, int index) {
		Student student = students.get(index);
		for (int i = 0; i < student.getClasses().size(); i++) {
			System.out.println((i + 1) + ": " + student.getClasses().get(i));
		}

		System.out.println("Welcher Kurs?");
		while ((index = scanner.nextInt()) < 1 || index > student.getClasses().size()) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Welcher Kurs?");
		}
		index--;

		double grade = 0.0;
		System.out.println("Note eingeben:");
		while ((grade = scanner.nextDouble()) < 1.0 || grade > 6.0) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Note eingeben:");
		}
		student.getClasses().get(index).setGrade(grade);
		System.out.println(student + " Note eingetragen");
	}

	public void addStudent(Scanner scanner) {
		String lastName;
		String firstName;
		long id;
		String eMail;
		int courseNumber;

		System.out.println("Nachname: ");
		lastName = scanner.nextLine();

		System.out.println("Vorname: ");
		firstName = scanner.nextLine();

		System.out.println("Matrikelnummer: ");
		id = 0;
		while ((id = scanner.nextLong()) < 10000000 || id > 99999999) {
			scanner.nextLine();
			System.out.println("ungueltige Matrikelnummer");
			System.out.println("Matrikelnummer: ");
		}
		scanner.nextLine();

		System.out.println("eMail: ");
		eMail = scanner.nextLine();

		System.out.println("1: Wirtschaftsinformatik (Bachelor)");
		System.out.println("2: Wirtschaftsinformatik (Master)");
		System.out.println("3: Allgemeine Informatik (Bachelor)");
		System.out.println("Studiengang: ");
		while ((courseNumber = scanner.nextInt()) < 1 || courseNumber > 3) {
			scanner.nextLine();
			System.out.println("ungueltiger Studiengang");
			System.out.println("1: Wirtschaftsinformatik (Bachelor)");
			System.out.println("2: Wirtschaftsinformatik (Master)");
			System.out.println("3: Allgemeine Informatik (Bachelor)");
			System.out.println("Studiengang: ");
		}
		scanner.nextLine();

		Student newStudent = new Student(firstName, lastName, eMail, id, courses.get(courseNumber - 1));
		students.add(newStudent);
		System.out.println(newStudent.toString() + " hinzugefuegt");
	}

}
