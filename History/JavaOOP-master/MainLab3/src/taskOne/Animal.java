package taskOne;

public abstract class Animal implements ICanEat, Moveable { // Multiple implementation is available
	int age;
	Gender gender;

	public Animal() {
	};

	public Animal(int age, Gender gender) {
		this.age = age; // abstract class can has fields
		this.gender = gender;
	}

	public abstract void voice(); // abstract class can has abstract methods, and concrete methods

	@Override
	public void move() {
		System.out.println("*Moves*");
	}

	@Override
	public void eat() {
		System.out.println("*Eats*");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
