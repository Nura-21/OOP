package task5;

public class Person {
	public String name;
	public int age;
	public Gender gender;
	
	public Person() {
		name = "Unknown";
		age = 19;
		gender = Gender.Boy;
	}
	public Person(String name) {
		this();
		this.name = name;
	}
	public Person(String name,int age) {
		this(name);
		this.age = age;
	}
	public Person(String name,int age,Gender gender) {
		this(name,age);
		this.gender = gender;
	}
	public Person(Gender gender) {
		this();
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Gender getGender() {
		return gender;
	}
	
	public String toString() {
		return "Name: " + name
				+ ". Age: " + age
				+ ". Gender: " + gender;
	}
	
	
}
