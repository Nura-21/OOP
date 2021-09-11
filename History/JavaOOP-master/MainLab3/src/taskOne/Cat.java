package taskOne;

public class Cat extends Animal { // classes can extend only 1 class
	String name;

	public Cat() {
	}

	public Cat(int age, Gender gender, String name) {
		super(age, gender);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void voice() {
		System.out.println("Meow");
	}

}
