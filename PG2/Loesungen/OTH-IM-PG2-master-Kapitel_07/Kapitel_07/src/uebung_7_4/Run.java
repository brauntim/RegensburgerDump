package uebung_7_4;

public class Run {

	public static void main(String[] args) {

		Employee e1 = new Employee("Maier", "Horst", Job.DISTRIBUTION);
		Employee e2 = new Employee("Schmidt", "Karl-Heinz", Job.ACCOUNTANT);
		Employee e3 = new Employee("Mueller", "Ruediger", Job.DEVELOPMENT);

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);

	}

}
