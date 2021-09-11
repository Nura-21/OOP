package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import mainClasses.*;
import wspEnums.Faculty;

public class TeacherController implements IDoAction {

	private void actionViewTeacherInfo(Teacher t) {
		System.out.println("ID: " + t.getId());
		System.out.println("Login: " + t.getLogin());
		System.out.println("First name: " + t.getName());
		System.out.println("Last name: " + t.getSurname());
		System.out.println("Email: " + t.getLogin() + "@kbtu.kz");
		System.out.println("Category: " + t.getTitle());
		System.out.println("Work Experience: " + t.getWorkExperience());
		System.out.println("Salary: " + t.getSalary());
	}

	private void actionViewStudents(String input, Teacher t, BufferedReader br) throws IOException, NoAccessException {
		System.out.println("You have foolowing courses:");
		for (Course c : t.getCourses())
			System.out.println(c.getCipher() + " " + c.getTitle() + " " + c.getDescription());
		System.out.print("Input the title of your course or [exit]:");
		input = br.readLine();
		if (input.equals("exit"))
			return;
		boolean checker = false;
		for (Course c : DataBase.getInstance().getCourses()) {
			if (c.getTitle().equals(input)) {
				System.out.println("Students on course : " + c.getTitle());
				Vector<Student> v = t.viewStudentsOnCourse(c);
				for (Student stud : v) {
					System.out.println("ID: " + stud.getId() + " Name " + stud.getName() + " " + stud.getSurname()
							+ " Year " + stud.getYearOfStudy() + " Faculty " + stud.getFaculty() + " Spec "
							+ stud.getSpeciality() + " " + stud.getDegree() + " " + stud.getStatus());
				}
				checker = true;
			}
		}
		if (!checker)
			System.out.println("There is no course with this title in the list of your courses");
	}

	private void actionCreateCourse(String input, Teacher t, BufferedReader br) throws IOException {
		System.out.print("Do you really want to create a new course?"
				+ " \nPress any button to proceed or press [exit] to quit: ");
		input = br.readLine();
		if (input.equals("exit")) {
			return;
		}
		System.out.print("Input a course code (example: CSCI2106, MATH1101, PHE102 etc.): ");
		String cipher = br.readLine();
		System.out.print("Input a course title / name: ");
		String title = br.readLine();
		System.out.print("For which faculty this course is? (FIT, ISE, MCM, KMA, BS): ");
		Faculty faculty;
		if (br.readLine().equals("FIT")) {
			faculty = Faculty.FIT;
		} else if (br.readLine().equals("ISE")) {
			faculty = Faculty.ISE;
		} else if (br.readLine().equals("MCM")) {
			faculty = Faculty.MCM;
		} else if (br.readLine().equals("KMA")) {
			faculty = Faculty.KMA;
		} else if (br.readLine().equals("BS")) {
			faculty = Faculty.BS;
		} else {
			System.out.println("There is no such faculty. Returning to menu...");
			return;
		}
		System.out.print("For which year of study this course is? Your input:");
		int year = Integer.parseInt(br.readLine());
		System.out.println("Almost done. Do you want to input course description & number of"
				+ " \ncredits now or later? [Y]es, now or [N]o, later?");
		Course c = null;
		if (br.readLine().equals("Y")) {
			System.out.print("Input a course description: ");
			String desc = br.readLine();
			System.out.print("Input a number of credits of this course: ");
			int credits = Integer.parseInt(br.readLine());
			c = new Course(cipher, title, desc, credits, year, faculty);
		} else {
			c = new Course(cipher, title, year, faculty);
		}
		if (t.createCourse(c)) {
			t.getCourses().add(c);
			System.out.println("Course successfully created. You can manage it through different action");
			return;
		} else {
			System.out.println("Course wasn't created, something must've gone wrong");
			return;
		}
	}

	private void actionPutMark(String input, Teacher t, BufferedReader br) throws IOException {
		while (true) {
			System.out.print("Input name of course, or [exit] or [check] to get your students: ");
			input = br.readLine();
			if (input.equals("exit"))
				return;
			else {
				boolean checker = false;
				for (Course c : t.getCourses()) {
					if (c.getTitle().equals(input))
						checker = true;
					System.out.println("Write id of student");
					input = br.readLine();
					for (Student s : c.getStudentsOnCourse()) {
						if (s.getId() == (Integer.parseInt(input))) {
							System.out.print("Input the mark: ");
							int mark = Integer.parseInt(br.readLine());
							System.out.print(
									"For which attestation do you want to put this mark? (first, second, final): ");
							input = br.readLine();
							System.out.println(mark);
							System.out.println(input);
							
							if (input.equals("first")) {
								s.getTranscript().getMarks().get(c).setFirstAtt(mark);
								checker = true;
							} else if (input.equals("second")) {
								s.getTranscript().getMarks().get(c).setSecondAtt(mark);
								checker = true;
							} else if (input.equals("first")) {
								s.getTranscript().getMarks().get(c).setFinalScore(mark);
								checker = true;
							}
							break;
						}
					}
				}
				if (!checker) {
					System.out.println("Something wrong");
				}
			}

		}
	}

	private void actionManageCourse(String input, Teacher t, BufferedReader br) throws IOException {
		System.out.print("Input the title of your course that you want to manage:");
		input = br.readLine();
		if (input.equals("0")) {
			return;
		}
		Course managedCourse = null;
		for (Course c : t.getCourses()) {
			if (c.getTitle().equals(input)) {
				managedCourse = c;
			}
		}
		if (managedCourse == null) {
			System.out.println("There is no course with this title in the list of your courses");
		} else {
			String help = "Here is the list of actions you can do to manage this course"
					+ " \nPress [1] to view course information" + " \nPress [2] to change the title (name)"
					+ " \nPress [3] to change the description" + " \nPress [4] to change the number of credits"
					+ " \nPress [5] to add files to the course" + " \nPress [6] to delete files from the course"
					+ " \nIf you need this memo again, press [9] (You can always press [0] to quit).";
			System.out.println(help);
			while (true) {
				System.out.print("Your input: ");
				input = br.readLine();
				if (input.equals("0")) {
					break;
				} else if (input.equals("9")) {
					System.out.println(help);
				} else if (input.equals("1")) {
					System.out.println(managedCourse.toString());
				} else if (input.equals("2")) {
					System.out.print("Input a new title: ");
					input = br.readLine();
					managedCourse.setTitle(input);
				} else if (input.equals("3")) {
					System.out.print("Input a new description: ");
					input = br.readLine();
					managedCourse.setDescription(input);
				} else if (input.equals("4")) {
					System.out.print("Input a new number of credits: ");
					input = br.readLine();
					int credits = Integer.parseInt(input);
					managedCourse.setCredits(credits);
				} else if (input.equals("5")) {
					System.out.print("Input a name of the file: ");
					input = br.readLine();
					System.out.print("Input contents of the file: ");
					String content = br.readLine();
					CourseFile file = new CourseFile(input, content);
					t.addFileToCourse(managedCourse, file);
				} else if (input.equals("6")) {
					System.out.print("Input a name of the file: ");
					input = br.readLine();
					for (CourseFile file : managedCourse.getCourseFiles()) {
						if (file.getTitle().equals(input)) {
							if (t.deleteFileFromCourse(managedCourse, file)) {
								System.out.println("File deleted successfully");
							} else
								System.out.println("File wasn't deleted. Something must've gone wrong");
							break;
						}
					}
				}
			}
		}

	}

	private void actionSendOrder(String input, Teacher t, BufferedReader br) throws IOException {
		System.out.print("Input the title of your order or [exit]: ");
		input = br.readLine();
		if (input.equals("exit"))
			return;
		String title = input;
		System.out.println("Input your order message(text): ");
		String body = br.readLine();
		System.out.println("Do you want to send this order? [Y]es or [N]o?");
		if (br.readLine().equals("Y")) {
			Order order = new Order(title, body, t, null);
			if (t.send(order))
				System.out.println("Order sent successfully");
			else
				System.out.println("Order wasn't sent. Something must've gone wrong");
		}
		return;
	}

	@Override
	public void startAction(User u) throws IOException {
		Teacher t = (Teacher) u;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String help = "Here is the list of actions available to you as a teacher"
				+ " \nPress [1] to view your own current information in the database"
				+ " \nPress [2] to get a list of students from one of your courses" + " \nPress [3] to create a course"
				+ " \nPress [4] to manage a course" + " \nPress [5] to send an order to tech support"
				+ " \nPress [6] to put marks"
				+ " \nIf you need this memo again, press [9] (You can always press [0] to quit).";
		System.out.println(help);
		while (true) {
			System.out.print("Your input: ");
			input = br.readLine();
			if (input.equals("0")) {
				break;
			} else if (input.equals("9")) {
				System.out.println(help);
			} else if (input.equals("1")) {
				actionViewTeacherInfo(t);
			} else if (input.equals("2")) {
				try {
					actionViewStudents(input, t, br);
				} catch (NoAccessException e) {
					e.printStackTrace();
				}
			} else if (input.equals("3")) {
				actionCreateCourse(input, t, br);
			} else if (input.equals("4")) {
				actionManageCourse(input, t, br);
			} else if (input.equals("5")) {
				actionSendOrder(input, t, br);
			} else if (input.equals("6")) {
				actionPutMark(input, t, br);
			}

		}
	}
}