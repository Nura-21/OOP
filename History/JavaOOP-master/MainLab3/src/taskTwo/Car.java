package taskTwo;

public class Car implements Driveable {
	private String model;

	public Car() {
	}

	public Car(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void move() {
		System.out.println("Car rides");

	}

	@Override
	public void changeGear() {
		System.out.println("Car gear has changed");

	}

	@Override
	public void start() {
		System.out.println("Car engine starts...");

	}

	@Override
	public void shutDown() {
		System.out.println("Car engine stops...");

	}
}
