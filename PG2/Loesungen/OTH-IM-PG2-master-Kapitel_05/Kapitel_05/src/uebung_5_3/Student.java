package uebung_5_3;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String eMail;
	private long id;
	private Course course;
	private List<Class> classes;

	public Student(String firstName, String lastName, String eMail, long id, Course course) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.id = id;
		this.course = course;
		classes = new ArrayList<>();
		for (int i = 0; i < course.getClasses().size(); i++) {
			classes.add(new Class(course.getClasses().get(i).getName(), course.getClasses().get(i).getCredits(),
					course.getClasses().get(i).getMultiplier()));
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public String geteMail() {
		return eMail;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", id=" + id
				+ ", course=" + course + "]";
	}

	public String getDetailInformation() {
		String info = this.toString() + System.lineSeparator();
		int multiplier = 0;
		double average = 0.0;

		for (int i = 0; i < classes.size(); i++) {
			if (classes.get(i).getGrade() > 0.0) {
				average += (classes.get(i).getGrade() * classes.get(i).getMultiplier());
				multiplier += classes.get(i).getMultiplier();
				info += classes.get(i).toString() + System.lineSeparator();
			}
		}
		if (multiplier > 0) {
			average /= multiplier;
		}

		info += "Notendurchschnitt: " + average;

		return info;
	}
}
