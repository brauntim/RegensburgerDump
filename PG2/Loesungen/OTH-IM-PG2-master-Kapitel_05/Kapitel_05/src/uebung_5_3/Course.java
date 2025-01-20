package uebung_5_3;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private List<Class> classes;

	public Course(String name) {
		this.name = name;
		this.classes = new ArrayList<>();
	}

	public void addClass(String name, int credits, int multiplier) {
		this.classes.add(new Class(name, credits, multiplier));
	}

	public String getName() {
		return name;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
}
