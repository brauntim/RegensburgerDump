package uebung_8_4;

public class Job implements Comparable<Job>{
	private String name;
	private double salary;

	public Job(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		if(Double.compare(this.salary, o.getSalary()) > 0) {
			return 1;
		}
		else if(Double.compare(this.salary, o.getSalary()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
