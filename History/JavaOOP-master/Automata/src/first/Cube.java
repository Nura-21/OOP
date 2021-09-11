package first;

public class Cube extends Shapes3D {
	private double side;

	public Cube() {
		side = 0;
	}

	public Cube(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double volume() {
		return side * side * side;
	}

	public double surfaceArea() {
		return 6 * (side * side);
	}

	public String toString() {
		return "Cube. Side = " + side;
	}
}
