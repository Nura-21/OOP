package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mainClasses.Admin;
import mainClasses.DataBase;
import mainClasses.Student;
import mainClasses.User;
import mainClasses.*;
import wspEnums.*;

public class AdminController implements IDoAction {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	AdminController() {
	}

	public void actionRemoveUser(Admin a) throws IOException {
		String input = "";
		String help = "\nInput user id to remove." + " \nPress [check] to check users database"
				+ " \nPress [exit] to back to menu";
		while (true) {
			System.out.println(help);
			System.out.print("Input: ");
			input = br.readLine();
			if (input.equals("exit"))
				break;
			else if (input.equals("check")) {
				System.out.println("Database:");
				for (User u : DataBase.getInstance().getUsers())
					System.out.println(u);
			} else {
				boolean flag = false;
				if (Integer.toString(a.getId()).equals(input)) {
					System.out.println("You cannot delete yourself");
					continue;
				}
				for (User u : DataBase.getInstance().getUsers())
					if (Integer.toString(u.getId()).equals(input)) {
						a.removeUser(u);
						System.out.println("User has been deleted");
						flag = true;
						break;
					}
				if (!flag)
					System.out.println("There is no such user");
			}
		}
	}

	public void actionAddUser(Admin a) throws IOException {
		String input = "";
		String help = "Do following steps to add user";
		while (true) {
			System.out.println(help);
			System.out.println("Input type of user: [STUDENT,MANAGER,ADMIN,TECHSUPPORTER,TEACHER]. [exit] - to exit.");
			input = br.readLine();
			if (input.equals("exit"))
				break;
			User usr = UserFactory.getInstance().getUser(input);
			if (usr.equals(null)) {
				System.out.println("Wrong type of user");
				continue;
			}
			System.out.print("Write name of user: ");
			input = br.readLine();
			usr.setName(input);
			System.out.print("Write surname of user: ");
			input = br.readLine();
			usr.setSurname(input);
			if (a.addUser(usr))
				System.out.println("User has been added");
			else
				System.out.println("User has not been added");
		}
	}

	public void actionUpdateUser(Admin a) throws IOException {
		String input = "";
		String help = "\nInput user id to update." + " \nPress [check] to check users database"
				+ " \nPress [exit] to back to menu";
		while (true) {
			System.out.println(help);
			input = br.readLine();
			if (input.equals("exit"))
				break;
			else if (input.equals("check")) {
				System.out.println("Database:");
				for (User u : DataBase.getInstance().getUsers())
					System.out.println(u);
			} else {
				boolean flag = false;
				if (Integer.toString(a.getId()).equals(input)) {
					System.out.println("You cannot change yourself");
					continue;
				}
				for (User user : DataBase.getInstance().getUsers())
					if (Integer.toString(user.getId()).equals(input)) {
						System.out.println("Input new password of user, or [cancel].");
						input = br.readLine();
						if (!input.equals("cancel"))
							user.setPassword(input);
						if (user.getUserType().equals(UserType.TEACHER)
								|| user.getUserType().equals(UserType.TECHSUPPORT)
								|| user.getUserType().equals(UserType.TEACHER)) {
							Employee e = (Employee) user;
							System.out.println("Input new salary of user, or [cancel].");
							input = br.readLine();
							if (!input.equals("cancel"))
								e.setSalary(Integer.parseInt(input));
							System.out.println("Input new work experience of user, or [cancel].");
							input = br.readLine();
							if (!input.equals("cancel"))
								e.setWorkExperience(Integer.parseInt(input));
						}
						System.out.println("User has been changed");
						flag = true;
						break;
					}
				if (!flag)
					System.out.println("There is no such user");
			}

		}
	}

	public void actionCheckLogs(Admin a) throws IOException {
		String input = "";
		String help = "Choose DataBase:" + "\n[Users],[Admins],[Managers],[Teachers],[Students],[TechSupporters]"
				+ "\n[Messages],[CurrentOrders],[DoneOrders],[Courses]" + " \nPress [exit] to back to menu";
		while (true) {
			System.out.println(help);
			input = br.readLine();
			if (input.equals("exit"))
				break;
			if (input.equalsIgnoreCase("Users")) {
				System.out.println("Users:");
				for (User u : DataBase.getInstance().getUsers())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Students")) {
				System.out.println("Students:");
				for (Student u : DataBase.getInstance().getStudents())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Admins")) {
				System.out.println("Admins:");
				for (Admin u : DataBase.getInstance().getAdmins())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Managers")) {
				System.out.println("Managers:");
				for (Manager u : DataBase.getInstance().getManagers())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Teachers")) {
				System.out.println("Teachers:");
				for (Teacher u : DataBase.getInstance().getTeachers())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("TechSupporters")) {
				System.out.println("TechSupporters:");
				for (TechSupporter u : DataBase.getInstance().getTechSupporters())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Messages")) {
				System.out.println("Messages:");
				for (Message u : DataBase.getInstance().getMessages())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("CurrentOrders")) {
				System.out.println("CurrentOrders:");
				for (Order u : DataBase.getInstance().getCurrentOrders())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("DoneOrders")) {
				System.out.println("DoneOrders:");
				for (Order u : DataBase.getInstance().getDoneOrders())
					System.out.println(u);
			} else if (input.equalsIgnoreCase("Courses")) {
				System.out.println("Courses:");
				for (Course u : DataBase.getInstance().getCourses())
					System.out.println(u);
			} else {
				System.out.println("Wrong pattern");
			}

		}

	}

	@Override
	public void startAction(User u) throws IOException {
		Admin a = (Admin) u;
		String input = "";
		String help = "\nHere is the list of actions available to you as an admin"
				+ " \nPress [1] to add the user in the database" + " \nPress [2] to remove the user in the database"
				+ " \nPress [3] to update the user in the database" + " \nPress [4] to check logs";
		System.out.println(help);
		while (true) {
			System.out.println("If you need menu again, press [9] (You can always press [0] to quit).");
			System.out.print("Your input: ");
			input = br.readLine();
			if (input.equals("0")) {
				break;
			} else if (input.equals("9")) {
				System.out.println(help);
			} else if (input.equals("1")) {
				actionAddUser(a);
			} else if (input.equals("2")) {
				actionRemoveUser(a);
			} else if (input.equals("3")) {
				actionUpdateUser(a);
			} else if (input.equals("4")) {
				actionCheckLogs(a);
			}
		}

	}

}
