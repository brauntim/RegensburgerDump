package uebung_6_6;

public class Programm {

	public static void main(String[] args) {
		Student tomStudent = new Student();
		tomStudent.setFirstName("Tom");
		tomStudent.setLastName("Teuer");
		System.out.println(tomStudent.getFirstName() + ": " + tomStudent.getID());

		Student reginaStudent = new Student();
		reginaStudent.setFirstName("Regina");
		reginaStudent.setLastName("Reich");
		System.out.println(reginaStudent.getFirstName() + ": " + reginaStudent.getID());

		Student leaStudent = new Student();
		leaStudent.setFirstName("Lea");
		leaStudent.setLastName("Lustig");
		System.out.println(leaStudent.getFirstName() + ": " + leaStudent.getID());

	}

}
