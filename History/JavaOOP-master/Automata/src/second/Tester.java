package second;

import java.util.HashSet;

public class Tester {

	public static void main(String[] args) {
		HashSet<User> users = new HashSet<User>();
		User u1 = new User("Ivan", "123");
		User u2 = new User("Ivan", "123");
		User u3 = new User("Egor", "123");
		Moder m1 = new Moder("Petr", "123", "321");
		Moder m2 = new Moder("Petr", "123", "321");
		Moder m3 = new Moder("Sergey", "123", "321");
		Admin a1 = new Admin("Vlad", "123", "321", "qwe");
		Admin a2 = new Admin("Vlad", "123", "321", "qwe");
		Admin a3 = new Admin("Vitaliy", "123", "321", "qwe");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(m1);
		users.add(m2);
		users.add(m3);
		users.add(a1);
		users.add(a2);
		users.add(a3);
		for (User usr : users) {
			usr.logIn();
		}
		System.out.println(" ");
		for (User usr : users) {
			if (usr instanceof Moder)
				((Moder) usr).changeInfo();
			else if (usr instanceof Admin)
				((Admin) usr).changeInfo();
		}
		System.out.println(" ");
		for (User usr : users) {
			if (usr instanceof Admin)
				((Admin) usr).ban();
		}
	}

}
