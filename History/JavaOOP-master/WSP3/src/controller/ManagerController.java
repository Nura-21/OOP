package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mainClasses.*;

public class ManagerController implements IDoAction {

	private void actionViewManagerInfo(Manager m) {
		System.out.println("ID: " + m.getId());
		System.out.println("Login: " + m.getLogin());
		System.out.println("First name: " + m.getName());
		System.out.println("Last name: " + m.getSurname());
		System.out.println("Email: " + m.getLogin() + "@kbtu.kz");
		System.out.println("Work Experience: " + m.getWorkExperience());
		System.out.println("Salary: " + m.getSalary());
	}

	private String showUnavailableCourses() {
		String res = "";
		for (Course c : DataBase.getInstance().getCourses()) {
			if (!c.isAvailable()) {
				res += c.toString();
				res += '\n';
			}
		}
		return res;
	}

	private void actionViewCourses(String input, Manager m, BufferedReader br)
			throws IOException, CloneNotSupportedException {
		System.out.println(showUnavailableCourses());
		while (true) {
			System.out.println("Input the cipher (code) of the course you want to accept"
					+ " \nIf you need list of courses you can press [6]" + " \n(You can always press [0] to exit)");
			input = br.readLine();
			if (input.equals("0"))
				return;
			if (input.equals("6")) {
				System.out.println(showUnavailableCourses());
			} else {
				boolean checker = false;
				for (Course c : DataBase.getInstance().getCourses()) {
					if (c.getCipher().equals(input)) {
						m.acceptCourse(c);
						System.out.println("Course was accepted");
						checker = true;
						break;
					}
				}
				if (!checker)
					System.out.println("There is no such course");
			}
		}
	}

	private void actionSendMessage(String input, Manager m, BufferedReader br) throws IOException {
		System.out.print("Input the title of your message: ");
		String title = br.readLine();
		System.out.println("Input your message (text): ");
		String body = br.readLine();
		System.out.println("Do you want to send this message? [Y]es or [N]o?");
		if (br.readLine().equals("Y")) {
			Message message = new Message(title, body, m, null);
			if (m.send(message))
				System.out.println("Message sent successfully");
			else
				System.out.println("Message wasn't sent. Something must've gone wrong");
		}
		return;
	}

	@Override
	public void startAction(User u) throws IOException, CloneNotSupportedException {
		Manager m = (Manager) u;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String help = "Here is the list of actions available to you as a manager"
				+ " \nPress [1] to view your own current information in the database"
				+ " \nPress [2] to get a list of students by their GPA"
				+ " \nPress [3] to get a list of teacher by their rating"
				+ " \nPress [4] to view new courses and decide whether to accept them or not"
				+ " \nPress [5] to send an message to an employee of this university"
				+ " \nIf you need this menu again, press [9] (You can always press [0] to quit).";
		System.out.println(help);
		while (true) {
			System.out.print("Your input: ");
			input = br.readLine();
			if (input.equals("0")) {
				break;
			} else if (input.equals("9")) {
				System.out.println(help);
			} else if (input.equals("1")) {
				actionViewManagerInfo(m);
			} else if (input.equals("2")) {
				System.out.println(m.viewStudentsByGPA());
			} else if (input.equals("3")) {
				System.out.println(m.viewTeachersByRating());
			} else if (input.equals("4")) {
				actionViewCourses(input, m, br);
			} else if (input.equals("5")) {
				actionSendMessage(input, m, br);
			}
		}

	}

}
