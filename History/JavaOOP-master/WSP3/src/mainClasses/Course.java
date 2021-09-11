package mainClasses;

import java.util.Vector;
import java.io.Serializable;
import java.util.Objects;

import wspEnums.Faculty;

public class Course implements Serializable {
	private String cipher;
	private String title;
	private String description;
	private int credits;
	private Vector<Course> prerequisites;
	private Vector<CourseFile> courseFiles;
	private int yearOfStudy;
	private Faculty faculty;
	private Vector<Student> studentsOnCourse;
	private boolean available;

	public Course() {
		this.cipher = "DFLT000";
		this.title = "new course";
		this.description = " ";
		this.credits = 0;
		this.yearOfStudy = 0;
		this.available = false;
		prerequisites = new Vector<Course>();
		courseFiles = new Vector<CourseFile>();
		studentsOnCourse = new Vector<Student>();
	}

	public Course(String cipher, String title, int yearOfStudy, Faculty faculty) {
		this();
		this.cipher = cipher;
		this.title = title;
		this.yearOfStudy = yearOfStudy;
		this.faculty = faculty;
	}

	public Course(String cipher, String title, String description, int credits, int yearOfStudy, Faculty faculty) {
		this(cipher, title, yearOfStudy, faculty);
		this.description = description;
		this.credits = credits;
	}

	public String getCipher() {
		return cipher;
	}

	public void setCipher(String cipher) {
		this.cipher = cipher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Vector<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Vector<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public Vector<CourseFile> getCourseFiles() {
		return courseFiles;
	}

	public void setCourseFiles(Vector<CourseFile> courseFiles) {
		this.courseFiles = courseFiles;
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

	public Vector<Student> getStudentsOnCourse() {
		return studentsOnCourse;
	}

	public void setStudentsOnCourse(Vector<Student> studentsOnCourse) {
		this.studentsOnCourse = studentsOnCourse;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		return "Course [cipher = " + cipher + ", title = " + title + ", description = " + description + ", credits = "
				+ credits + ", prerequisites = " + prerequisites + ", courseFiles = " + courseFiles + ", yearOfStudy = "
				+ yearOfStudy + ", faculty = " + faculty +  ", available = "
				+ available + "]";
	}

	public int hashCode() {
		return Objects.hash(available, cipher, courseFiles, credits, description, faculty, prerequisites, title, yearOfStudy);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return available == other.available && credits == other.credits && yearOfStudy == other.yearOfStudy
				&& faculty == other.faculty && Objects.equals(cipher, other.cipher)
				&& Objects.equals(title, other.title) && Objects.equals(description, other.description)
				&& Objects.equals(prerequisites, other.prerequisites) && Objects.equals(courseFiles, other.courseFiles);
	}

	public Object clone() throws CloneNotSupportedException {
		Course clone = (Course) super.clone();
		clone.available = this.available;
		clone.cipher = this.cipher;
		clone.courseFiles = (Vector<CourseFile>) this.courseFiles.clone();
		clone.description = this.description;
		clone.credits = this.credits;
		clone.faculty = this.faculty;
		clone.prerequisites = (Vector<Course>) this.prerequisites.clone();
		clone.studentsOnCourse = (Vector<Student>) this.studentsOnCourse.clone();
		clone.yearOfStudy = this.yearOfStudy;
		clone.title = this.title;
		return clone;
	}

}
