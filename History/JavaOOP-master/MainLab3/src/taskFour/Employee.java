package taskFour;

import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Comparable, Cloneable {
	private double salary;
	private Date hireDate;
	private String insuranceNumber;

	public Employee() {
		super();
		salary = 0;
		hireDate = null;
		insuranceNumber = "Undefined";
	}

	public Employee(String name, double salary, Date hireDate, String insuranceNumber) {
		super(name);
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public Employee clone() throws CloneNotSupportedException {
		Employee clone = (Employee) super.clone();
		clone.hireDate = (Date) hireDate.clone();
		return clone;
	}

	public int compareTo(Object o) {
		Employee e = (Employee) o;
		if (salary > e.salary)
			return 1;
		if (salary < e.salary)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", hireDate=" + hireDate + ", insuranceNumber=" + insuranceNumber
				+ ", Person=" + super.toString() + "]";
	}

	@Override
	public boolean equals(Object o) {
		Employee e = (Employee) o;
		return super.equals(o) && (salary == e.salary) && (insuranceNumber.equals(this.insuranceNumber))
				&& (hireDate.equals(e.hireDate));
	}

	@Override
	public int hashcode() {
		return super.hashcode() + Objects.hash(salary, hireDate, insuranceNumber);
	}
}
