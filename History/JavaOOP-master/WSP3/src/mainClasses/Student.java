package mainClasses;

import java.util.Objects;
import java.util.Vector;

import wspEnums.*;

public class Student extends User {
	private static final long serialVersionUID = -9007854980187166415L;
	private Degree degree;
	private int yearOfStudy;
	private Faculty faculty;
	private String speciality;
	private StudentStatus status;
	private Transcript transcript = new Transcript();
	private Vector<Course> courses = new Vector<Course>();
	private int balance;
	private int availableCredits = 21;

	public Student() {
		super();
		this.setUserType(UserType.STUDENT);
	}

	public Student(String name, String surname) {
		super(name, surname, UserType.STUDENT);
		this.setUserType(UserType.STUDENT);
	}

	public Student(String name, String surname, Degree degree, int yearOfStudy, Faculty faculty, String speciality) {
		this(name, surname);
		this.degree = degree;
		this.yearOfStudy = yearOfStudy;
		this.faculty = faculty;
		this.speciality = speciality;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAvailableCredits() {
		return availableCredits;
	}

	public void setAvailableCredits(int availableCredits) {
		this.availableCredits = availableCredits;
	}

	public boolean regForCourse(Course course) {
		if (course.isAvailable() && course.getYearOfStudy() <= this.yearOfStudy
				&& course.getCredits() <= this.availableCredits) {
			this.courses.add(course);
			course.getStudentsOnCourse().add(this);
			transcript.addCourse(course);
			this.availableCredits -= course.getCredits();
			return true;
		} else {
			return false;
		}
	}

	public boolean rateTeacher(Teacher teacher, int rating) {
		if (rating >= 0 && rating <= 10) {
			teacher.getRates().add(rating);
			return true;
		} else {
			return false;
		}
	}

	public String viewMark(Course course) {
		String res = "";
		res += this.transcript.getMarks().get(course).toString();
		return res;
	}

	public String toString() {
		return "Student" + super.toString() + "[degree=" + degree + ", yearOfStudy=" + yearOfStudy + ", faculty="
				+ faculty + ", speciality=" + speciality + ", status=" + status + ", transcript=" + transcript
				+ ", courses=" + courses + ", balance=" + balance + ", availableCredits=" + availableCredits + "]";
	}

	public int hashCode() {
		return super.hashCode()
				+ Objects.hash(availableCredits, balance, degree, faculty, speciality, status, transcript, yearOfStudy);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return availableCredits == other.availableCredits && balance == other.balance && degree == other.degree
				&& faculty == other.faculty && status == other.status && yearOfStudy == other.yearOfStudy
				&& Objects.equals(speciality, other.speciality) && Objects.equals(courses, other.courses)
				&& Objects.equals(transcript, other.transcript);
	}

}
