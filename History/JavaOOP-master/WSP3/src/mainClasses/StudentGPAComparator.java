package mainClasses;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.getTranscript().getGPA() > s2.getTranscript().getGPA())
			return 1;
		else if (s1.getTranscript().getGPA() < s2.getTranscript().getGPA())
			return -1;
		return 0;
	}
}
