package uebung_8_3.shallow_copy;

public class Employee implements Cloneable {
	private int employeeId;
	private String employeeName;
	private Department department;

	public Employee(int employeeId, String employeeName, Department department) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + ": Employee [employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", department=" + department + "]";
	}

	@Override
	protected Employee clone() {
		// TODO Auto-generated method stub
		try {
			return (Employee) super.clone();
		}
		catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
