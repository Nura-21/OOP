import java.util.Collections;
import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		Student s1 = new Student("Alex",2);
		Student s2 = new Student("Alex",1);
		Student s3 = new Student("Balex",3);
		Student s4 = new Student("Nalex",2);
		Student s5 = new Student("Calex",4);
		Vector<Student> students = new Vector<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		System.out.println(students);
		Collections.sort(students);
		System.out.println(students);
		Collections.sort(students,new StudentNameComparator());
		System.out.println(students);
		
	}

}
