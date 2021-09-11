package first;

public class Cylinder extends Shapes3D {
	private double radius;
	private double height;

	public Cylinder() {
		radius = 0;
		height = 0;
	}

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	public double getRadius() {
		return radius;
	}

	public double getHeight() {
		return height;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double volume() {
		return 3.14 * radius * radius * height;
	}

	public double surfaceArea() {
		return (2 * 3.14 * radius * height) + (2 * 3.14 * radius * radius);
	}

	public String toString() {
		return "Cylinder. Radius = " + radius + ". Height = " + height;
	}
}
