package probTwo;

import java.util.Vector;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Vector<Person> people = new Vector<Person>();
		while (true) {
			System.out.println("Q - exit.");
			System.out.print("What object you want to add? [Person|Student|Staff]: ");
			String systemCall = in.nextLine();
			if (systemCall.equals("Q"))
				break;
			else if (systemCall.equals("Person")) {
				System.out.print("Write name: ");
				String name = in.nextLine();
				System.out.print("Write address: ");
				String address = in.nextLine();
				people.addElement(new Person(name, address));
			} else if (systemCall.equals("Student")) {
				System.out.print("Write name: ");
				String name = in.nextLine();
				System.out.print("Write address: ");
				String address = in.nextLine();
				System.out.print("Write program: ");
				String program = in.nextLine();
				System.out.print("Write year: ");
				int year = in.nextInt();
				System.out.print("Write fee: ");
				double fee = in.nextDouble();
				people.addElement(new Student(name, address, program, year, fee));
			} else if (systemCall.equals("Staff")) {
				System.out.print("Write name: ");
				String name = in.nextLine();
				System.out.print("Write address: ");
				String address = in.nextLine();
				System.out.print("Write school: ");
				String school = in.nextLine();
				System.out.print("Write pay: ");
				double pay = in.nextDouble();
				people.addElement(new Staff(name, address, school, pay));
			}
		}
		System.out.println("Database: ");
		for (Person person : people)
			System.out.println(person.toString());
		in.close();
	}

}
