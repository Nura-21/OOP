package taskOne;

public class Car implements Moveable {
	private String model;
	private int maxSpeed;

	public Car() {
	}

	public Car(String model, int maxSpeed) {
		this.setModel(model);
		this.setMaxSpeed(maxSpeed);
	}

	@Override
	public void move() {
		System.out.println("*Drives*");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
