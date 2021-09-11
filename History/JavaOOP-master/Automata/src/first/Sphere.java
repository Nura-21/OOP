package first;

public class Sphere extends Shapes3D {
	private double radius;

	public Sphere() {
		radius = 0;
	}

	public Sphere(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double volume() {
		return ((double) 4 / 3) * 3.14 * radius * radius * radius;
	}

	public double surfaceArea() {
		return 4 * 3.14 * radius * radius;

	}

	public String toString() {
		return "Sphere. Radius = " + radius;
	}
}
