package taskTwo;

public class Cat implements Moveable {
	private String name;

	public Cat() {
	}

	public Cat(String name) {
		this.setName(name);
	}

	@Override
	public void move() {
		System.out.println("Cat moves");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
