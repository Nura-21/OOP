package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mainClasses.*;

public class StudentController implements IDoAction {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StudentController() {
	}

	public void actionViewStudentInfo(Student s) {
		System.out.println("ID: " + s.getId());
		System.out.println("Login: " + s.getLogin());
		System.out.println("First name: " + s.getName());
		System.out.println("Last name: " + s.getSurname());
		System.out.println("Email: " + s.getLogin() + "@kbtu.kz");
		System.out.println("Degree: " + s.getDegree());
		System.out.println("Faculty: " + s.getFaculty());
		System.out.println("Speciality: " + s.getSpeciality());
		System.out.println("Year of Study:" + s.getYearOfStudy());
		System.out.println("Current status: " + s.getStatus());
		System.out.println("Current balance: " + s.getBalance());
	}

	public void actionViewStudentMarks(String input, Student s) throws IOException {
		s.getTranscript().update();
		System.out.println("GPA " + s.getTranscript().getGPA());
		System.out.println("If you want to see all of your marks, then press [5],"
				+ " \notherwise input the name of the course you've registered to");
		input = br.readLine();
		if (input.equals("5")) {
			{
				System.out.println("Transcript");
				System.out.println(s.getTranscript().show());
			}
		} else {
			for (Course c : s.getCourses()) {
				if (c.getTitle().equals(input)) {
					System.out.println(s.viewMark(c));
					return;
				}
			}
			System.out.println(
					"There is no course with this title in the list of those" + " \ncourses you've registered to\n");
		}
	}

	public void actionViewCourseInfo(String input, Student s) throws IOException {
		while (true) {
			System.out.println(
					"Press [exit] - exit. Press[mycourses] - get courses. If you want to see files of course, write course cipher");
			input = br.readLine();
			if (input.equals("exit"))
				return;
			else if (input.equals("mycourses")) {
				System.out.println("Your courses: ");
				for (Course c : s.getCourses()) {
					System.out.println("Cipher " + c.getCipher() + " Title: " + c.getTitle() + " Description: "
							+ c.getDescription() + " Credits: " + c.getCredits());
				}
			} else {
				boolean checker = false;
				for (Course c : s.getCourses()) {
					if (c.getCipher().equals(input)) {
						checker = true;
						System.out.println(c.getCourseFiles());
					}
				}
				if (!checker)
					System.out.println("Something wrong...");
			}

		}
	}

	public String checkCourses() {
		String show = "";
		for (Course c : DataBase.getInstance().getCourses()) {
			if (c.isAvailable())
				show += c + "\n";
		}
		return show;
	}

	public void actionRegisterForCourse(String input, Student s) throws IOException {
		String availableC = checkCourses();
		while (true) {
			System.out.println("Number of available credits: " + s.getAvailableCredits() + " / " + 21);
			System.out.println("If you need a list of available courses, then press [5],"
					+ " \notherwise input title of the course you wish to register for:" + " [exit] - to exit");
			input = br.readLine();
			if (input.equals("exit"))
				break;
			else if (input.equals("5")) {
				System.out.println(availableC);
			} else {
				boolean checker = false;
				for (Course c : DataBase.getInstance().getCourses()) {
					if (c.getTitle().equals(input)) {
						if (s.regForCourse(c)) {
							System.out.println("You have been added to the course: " + c.getTitle());
							checker = true;
							break;
						} else {
							System.out.println("You cannot register for course: " + c.getTitle());
							checker = true;
							break;
						}
					}
				}
				if (!checker)
					System.out.println("There is no course with this title in the database");
			}
		}

	}

	public void actionGiveRating(String input, Student s) throws IOException {
		System.out.println("If you need a list of teachers & professors, then press [5],"
				+ " \notherwise input full name of the teacher you want to give rating to:");
		input = br.readLine();
		if (input.charAt(0) == '5') {
			String show = "";
			for (Teacher t : DataBase.getInstance().getTeachers()) {
				show += t.getTitle() + " " + t.getName() + " " + t.getSurname() + "\n";
			}
			System.out.println(show);
			input = br.readLine();
		}

		for (Teacher t : DataBase.getInstance().getTeachers()) {
			if ((t.getName() + " " + t.getSurname()).equals(input)) {
				System.out.println("On a scale from 0 to 10, how much do you rate this teacher?"
						+ " \n(here 0 is a minimum score, while 10 is a maximum)"
						+ " \nDon't worry, it's fully anonymous.");
				input = br.readLine();
				int rating = Integer.parseInt(input);
				if (s.rateTeacher(t, rating)) {
					System.out.println("Thank you for participation!");
				} else {
					System.out.println("Rating out of bounds, please calm down");
				}
				return;
			}
		}
		System.out.println("There is no teacher with this name in the database"
				+ " \nIn this system you should input their name first and then a surname"
				+ " \nRemember not to put blank spaces at the end of the input");
	}

	@Override
	public void startAction(User u) throws IOException {
		Student s = (Student) u;
		String input = "";
		String help = "\nHere is the list of actions available to you as a student"
				+ " \nPress [1] to view your own current information in the database"
				+ " \nPress [2] to view your marks" + " \nPress [3] to register for course"
				+ " \nPress [4] to rate a teacher" + " \nPress [5] to view course information";
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
				actionViewStudentInfo(s);
			} else if (input.equals("2")) {
				actionViewStudentMarks(input, s);
			} else if (input.equals("3")) {
				actionRegisterForCourse(input, s);
			} else if (input.equals("4")) {
				actionGiveRating(input, s);
			} else if (input.equals("5")) {
				actionViewCourseInfo(input, s);
			}

		}

	}

}