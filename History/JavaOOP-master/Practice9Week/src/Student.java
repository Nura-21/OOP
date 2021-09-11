public class Student implements Comparable<Student> {
	private String name;
	private int id;

	Student() {
	}

	Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return String.format("Name: %s. Id: %s.", name, id);
	}

	@Override
	public int compareTo(Student s) {
		if (id > s.id)
			return 1;
		if (id < s.id)
			return -1;
		return 0;
	}

}