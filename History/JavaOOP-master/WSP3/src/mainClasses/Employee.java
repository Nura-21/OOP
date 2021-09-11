package mainClasses;

import java.util.Objects;

import wspEnums.UserType;

public abstract class Employee extends User {
	private static final long serialVersionUID = -7233641510310047151L;
	private int salary;
	private int workExperience;

	public Employee() {
		super();
		salary = 0;
		workExperience = 0;
	}

	public Employee(String name, String surname, UserType userType) {
		super(name, surname, userType);
	}

	public Employee(String name, String surname, UserType userType, int salary, int workExperience) {
		this(name, surname, userType);
		this.salary = salary;
		this.workExperience = workExperience;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	public abstract boolean send(Message message);

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", workExperience=" + workExperience + " " + super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(salary, workExperience);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (salary != other.salary)
			return false;
		if (workExperience != other.workExperience)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee clone = (Employee) super.clone();
		clone.salary = salary;
		clone.workExperience = workExperience;
		return clone;
	}

}