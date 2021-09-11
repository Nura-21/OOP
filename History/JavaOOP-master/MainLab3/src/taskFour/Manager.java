package taskFour;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee implements Comparable {
	private Vector<Employee> employees = new Vector<>();
	private int bonus;

	public Manager() {
		super();
		bonus = 0;
	}

	public Manager(String name, double salary, Date hireDate, String insuranceNumber, int bonus) {
		super(name, salary, hireDate, insuranceNumber);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public Vector<Employee> getEmployees() {
		return employees;
	}

	public void addToTeam(Employee e) {
		bonus += 2;
		employees.add(e);
	}

	@SuppressWarnings("unchecked")
	public Manager clone() throws CloneNotSupportedException {
		Manager clone = (Manager) super.clone();
		clone.employees = (Vector<Employee>) employees.clone();
		clone.bonus = bonus;
		return clone;
	}

	@Override
	public int compareTo(Object o) {
		int tmp = super.compareTo(o);
		if (tmp == 0) {
			Manager m = (Manager) o;
			if (bonus > m.bonus)
				return 1;
			if (bonus < m.bonus)
				return -1;
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "Manager [employees=" + employees + ", bonus=" + bonus + ", Employee=" + super.toString() + "]";
	}

	@Override
	public boolean equals(Object o) {
		Manager m = (Manager) o;
		return (bonus == m.bonus) && employees.equals(m.employees) && super.equals(o);
	}

	@Override
	public int hashcode() {
		return super.hashcode() + Objects.hash(employees, bonus);
	}

}
