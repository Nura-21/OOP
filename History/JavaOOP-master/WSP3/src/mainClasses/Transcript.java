package mainClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import wspEnums.TextGrade;

public class Transcript implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 275313676526823168L;
	private double gpa;
	private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();

	public Transcript() {
		this.gpa = 0;
	}

	public double getGPA() {
		return gpa;
	}

	public HashMap<Course, Mark> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Course, Mark> marks) {
		this.marks = marks;
	}

	public void update() {
		int totalCredits = 0;
		this.gpa = 0;
		for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
			totalCredits += entry.getKey().getCredits();
			this.gpa += (entry.getKey().getCredits() * TextGrade.getDigitalGrade(entry.getValue().getTextGrade()));
		}
		if (totalCredits > 0) {
			this.gpa /= totalCredits;
		}
	}

	public String show() {
		String res = "";
		for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
			res += entry.getKey().getTitle() + ": " + entry.getValue().toString();
		}
		return res;
	}

	public String toString() {
		return "Transcript [ gpa = " + gpa + ", marks = " + marks + "]";
	}

	public void addCourse(Course crs) {
		marks.put(crs, new Mark());
	}

	public int hashCode() {
		return Objects.hash(gpa, marks);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transcript other = (Transcript) obj;
		return Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa) && Objects.equals(marks, other.marks);
	}

	public int compareTo(Object o) {
		Transcript t = (Transcript) o;
		return Double.compare(this.gpa, t.getGPA());
	}
}
