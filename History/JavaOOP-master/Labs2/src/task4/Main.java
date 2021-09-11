package task4;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Course pp1 = new Course("PP1", "Principles Programming 1", 4);
		Course ads = new Course("ADS", "Algorithms and Data Structures", 3, pp1);
		Course se = new Course("SE", "Software Engineering", 3, ads);

		Student s1 = new Student("Daniil");
		Student s2 = new Student("Dmitry");
		Student s3 = new Student("Lebowski"); // where is the money Lebowski?
		Student s4 = new Student("Ivan");
		Student s5 = new Student("Miras");

		Vector<Student> students = new Vector<Student>();
		students.addElement(s1);
		students.addElement(s2);
		students.addElement(s3);
		students.addElement(s4);
		students.addElement(s5);

		GradeBook gb = new GradeBook(se, students);
		gb.displayMessage();

		for (int i = 0; i < students.size(); i++) {
			System.out.print("Grade of " + students.elementAt(i).getName() + " : ");
			int numb = in.nextInt();
			students.elementAt(i).setGrade(numb);
		}

		gb.displayGradeReport();
		in.close();
	}

}
