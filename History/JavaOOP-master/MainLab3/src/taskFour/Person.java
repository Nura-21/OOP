package taskFour;

import java.util.Objects;

public class Person {
	private String name;

	public Person() {
		name = "Unknown";
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public boolean equals(Object o) {
		Person p = (Person) o;
		return name.equals(p.name);
	}

	public int hashcode() {
		return Objects.hash(name);
	}
}
