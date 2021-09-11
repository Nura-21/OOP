package mainClasses;

import java.util.Comparator;

public class TeacherRatingComparator implements Comparator<Teacher> {
	public int compare(Teacher t1, Teacher t2) {
		if (t1.getRating() > t2.getRating())
			return 1;
		else if (t1.getRating() < t2.getRating())
			return -1;
		return 0;
	}

}
