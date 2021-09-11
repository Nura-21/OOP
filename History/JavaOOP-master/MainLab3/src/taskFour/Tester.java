package taskFour;

import java.util.Collections;

public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Ivan", 200.0, DateParser.parseDate("2020-07-01"), "00003");
		Employee e2 = new Employee("Ergeldi", 230.0, DateParser.parseDate("2020-07-05"), "00044");
		Employee e3 = new Employee("Ernur", 250.0, DateParser.parseDate("2020-08-13"), "00032");
		Employee e4 = new Employee("Ali", 250.0, DateParser.parseDate("2020-09-03"), "00002");
		Employee e5 = new Employee("Kyamran", 300.0, DateParser.parseDate("2020-09-11"), "00023");
		Employee e6 = new Employee("Dmitry", 150.0, DateParser.parseDate("2020-09-26"), "00203");
		Manager m1 = new Manager("Daniil", 500.0, DateParser.parseDate("2020-09-03"), "00001", 0);
		m1.addToTeam(e1);
		m1.addToTeam(e2);
		m1.addToTeam(e3);
		m1.addToTeam(e4);
		m1.addToTeam(e5);
		m1.addToTeam(e6);
		System.out.println("Without Sort");
		for (Employee e : m1.getEmployees()) {
			System.out.println(e);
		}
		System.out.println("Base sort");
		Collections.sort(m1.getEmployees());
		for (Employee e : m1.getEmployees()) {
			System.out.println(e);
		}
		System.out.println("By names");
		Collections.sort(m1.getEmployees(), new NameComparator());
		for (Employee e : m1.getEmployees()) {
			System.out.println(e);
		}
		System.out.println("By date");
		Collections.sort(m1.getEmployees(), new DateComparator());
		for (Employee e : m1.getEmployees()) {
			System.out.println(e);
		}
		Manager m2 = m1.clone();
		m2.setName("DaniilClone");
		m2.setSalary(1000.0);
		System.out.println(m1);
		System.out.println(m2);

	}

}
// OUTPUT
//Without Sort
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Base sort
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
//By names
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
//By date
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Manager [employees=[Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]], Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]], Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]], Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]], Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]], Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]], bonus=12, Employee=Employee [salary=500.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00001, Person=Person [name=Daniil]]]
//Manager [employees=[Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]], Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]], Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]], Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]], Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]], Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]], bonus=12, Employee=Employee [salary=1000.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00001, Person=Person [name=DaniilClone]]]
