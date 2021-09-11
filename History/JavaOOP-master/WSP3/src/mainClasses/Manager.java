package mainClasses;

import java.util.Collections;
import java.util.Vector;
import wspEnums.UserType;

public class Manager extends Employee {
	private static final long serialVersionUID = -8574621645050351189L;

	public Manager() {
		super();
		super.setUserType(UserType.MANAGER);
	}

	public Manager(String name, String surname) {
		super(name, surname, UserType.MANAGER);
	}

	public Manager(String name, String surname, int salary, int workExperience) {
		super(name, surname, UserType.MANAGER, salary, workExperience);
	}

	public boolean acceptCourse(Course course) {
		for (Course c : DataBase.getInstance().getCourses()) {
			if (course.equals(c)) {
				c.setAvailable(true);
				return true;
			}
		}
		return false;

	}

	public String viewStudentsByGPA() {
		String res = "";
		Vector<Student> v = new Vector<Student>();
		v.addAll(DataBase.getInstance().getStudents());
		Collections.sort(v, new StudentGPAComparator());
		for (Student s : v) {
			res += s;
			res += '\n';
		}
		return res;
	}

	@Override
	public String toString() {
		return "Manager [" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public String viewTeachersByRating() {
		String res = "";
		Vector<Teacher> v = new Vector<Teacher>();
		v.addAll(DataBase.getInstance().getTeachers());
		Collections.sort(v, new TeacherRatingComparator());
		for (Teacher s : v) {
			res += s;
			res += '\n';
		}
		return res;
	}

	@Override
	public boolean send(Message message) {
		return DataBase.getInstance().getMessages().add(message);
	}
}
