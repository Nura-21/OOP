package taskFive;

import taskFour.Employee;
import taskFour.DateParser;

public class Tester {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Time t1 = new Time(12, 30, 36);
		Time t2 = new Time(11, 33, 30);
		Time t3 = new Time(12, 30, 37);
		Time t4 = new Time(14, 31, 31);
		Time t5 = new Time(12, 26, 25);
		Time t6 = new Time(14, 31, 12);
		Time t7 = new Time(13, 33, 32);
		Time[] times = { t1, t2, t3, t4, t5, t6, t7 };
		System.out.println("Times before sort:");
		for (Time time : times)
			System.out.println(time);
//		Sort.sort(times);
		Sort.fastSort(times, 0, times.length - 1);
		System.out.println("Times after sort:");
		for (Time time : times)
			System.out.println(time);

		Chocolate c1 = new Chocolate(100.0, "Twix");
		Chocolate c2 = new Chocolate(150.0, "Snickers");
		Chocolate c3 = new Chocolate(90.0, "Kit-kat");
		Chocolate c4 = new Chocolate(500.0, "Merci");
		Chocolate[] chocolates = { c1, c2, c3, c4 };
		System.out.println("Chocolates before sort:");
		for (Chocolate ch : chocolates)
			System.out.println(ch);
//		Sort.sort(chocolates);
		Sort.fastSort(chocolates, 0, chocolates.length - 1);
		System.out.println("Chocolates after sort:");
		for (Chocolate ch : chocolates)
			System.out.println(ch);

		Employee e1 = new Employee("Ivan", 200.0, DateParser.parseDate("2020-07-01"), "00003");
		Employee e2 = new Employee("Ergeldi", 230.0, DateParser.parseDate("2020-07-05"), "00044");
		Employee e3 = new Employee("Ernur", 250.0, DateParser.parseDate("2020-08-13"), "00032");
		Employee e4 = new Employee("Ali", 250.0, DateParser.parseDate("2020-09-03"), "00002");
		Employee e5 = new Employee("Kyamran", 300.0, DateParser.parseDate("2020-09-11"), "00023");
		Employee e6 = new Employee("Dmitry", 150.0, DateParser.parseDate("2020-09-26"), "00203");
		Employee[] employees = { e1, e2, e3, e4, e5, e6 };
		for (Employee employee : employees)
			System.out.println(employee);
//		Sort.sort(employees);
		Sort.fastSort(employees, 0, employees.length - 1);
		System.out.println("Employees after sort:");
		for (Employee employee : employees)
			System.out.println(employee);

	}

}
//Times before sort:
//Time [hour=12, minute=30, second=36]
//Time [hour=11, minute=33, second=30]
//Time [hour=12, minute=30, second=37]
//Time [hour=14, minute=31, second=31]
//Time [hour=12, minute=26, second=25]
//Time [hour=14, minute=31, second=12]
//Time [hour=13, minute=33, second=32]
//Times after sort:
//Time [hour=11, minute=33, second=30]
//Time [hour=12, minute=26, second=25]
//Time [hour=12, minute=30, second=36]
//Time [hour=12, minute=30, second=37]
//Time [hour=13, minute=33, second=32]
//Time [hour=14, minute=31, second=12]
//Time [hour=14, minute=31, second=31]
//Chocolates before sort:
//Chocolate [weight=100.0, name=Twix]
//Chocolate [weight=150.0, name=Snickers]
//Chocolate [weight=90.0, name=Kit-kat]
//Chocolate [weight=500.0, name=Merci]
//Chocolates after sort:
//Chocolate [weight=90.0, name=Kit-kat]
//Chocolate [weight=100.0, name=Twix]
//Chocolate [weight=150.0, name=Snickers]
//Chocolate [weight=500.0, name=Merci]
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Employees after sort:
//Employee [salary=150.0, hireDate=Sat Sep 26 00:00:00 ALMT 2020, insuranceNumber=00203, Person=Person [name=Dmitry]]
//Employee [salary=200.0, hireDate=Wed Jul 01 00:00:00 ALMT 2020, insuranceNumber=00003, Person=Person [name=Ivan]]
//Employee [salary=230.0, hireDate=Sun Jul 05 00:00:00 ALMT 2020, insuranceNumber=00044, Person=Person [name=Ergeldi]]
//Employee [salary=250.0, hireDate=Thu Sep 03 00:00:00 ALMT 2020, insuranceNumber=00002, Person=Person [name=Ali]]
//Employee [salary=250.0, hireDate=Thu Aug 13 00:00:00 ALMT 2020, insuranceNumber=00032, Person=Person [name=Ernur]]
//Employee [salary=300.0, hireDate=Fri Sep 11 00:00:00 ALMT 2020, insuranceNumber=00023, Person=Person [name=Kyamran]]
