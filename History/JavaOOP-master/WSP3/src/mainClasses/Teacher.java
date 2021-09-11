package mainClasses;

import java.util.Objects;
import java.util.Vector;
import wspEnums.TeacherTitle;
import wspEnums.UserType;

public class Teacher extends Employee {
	private static final long serialVersionUID = 1L;
	private Vector<Course> courses = new Vector<Course>();
	TeacherTitle title;
	private Vector<Integer> rates = new Vector<Integer>();

	Teacher() {
		super();
		super.setUserType(UserType.TEACHER);
	}

	public Teacher(String name, String surname) {
		super(name, surname, UserType.TEACHER);
	}

	public Teacher(String name, String surname, int salary, int workExperience, TeacherTitle title) {
		super(name, surname, UserType.TEACHER, salary, workExperience);
		this.title = title;
	}

	public boolean createCourse(Course course) {
		return DataBase.getInstance().getCourses().add(course);
	}

	public Vector<Student> viewStudentsOnCourse(Course course) throws NoAccessException {
		if (this.courses.contains(course))
			return course.getStudentsOnCourse();
		return null;
	}

	public boolean putMark(Student student, Course course, int mark, String grade) {
		if (grade.equals("first"))
			student.getTranscript().getMarks().get(course).setFirstAtt(mark);
		if (grade.equals("second"))
			student.getTranscript().getMarks().get(course).setSecondAtt(mark);
		if (grade.equals("final"))
			student.getTranscript().getMarks().get(course).setFinalScore(mark);
		return true;
	}

	public boolean addFileToCourse(Course course, CourseFile textFile) {
		if (this.courses.contains(course))
			return course.getCourseFiles().add(textFile);
		return false;
	}

	public boolean deleteFileFromCourse(Course course, CourseFile textFile) {
		if (this.courses.contains(course))
			return course.getCourseFiles().remove(textFile);
		return false;
	}

	@Override
	public boolean send(Message message) {
		Order o = (Order) message;
		return DataBase.getInstance().getCurrentOrders().add(o);
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public TeacherTitle getTitle() {
		return title;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}

	public Vector<Integer> getRates() {
		return rates;
	}

	public double getRating() {
		double res = 0;
		for (Integer r : rates)
			res += r;
		return res / rates.size();
	}

	public void setRates(Vector<Integer> rates) {
		this.rates = rates;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(courses, rates, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(rates, other.rates) && title == other.title;
	}

	@Override
	public String toString() {
		return "Teacher [courses=" + courses + ", title=" + title + ", rates=" + rates + " [" + super.toString() + "]";
	}

}