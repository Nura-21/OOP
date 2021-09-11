package first;

import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		Vector<Shapes3D> shapes = new Vector<Shapes3D>();
		shapes.add(new Cylinder(3, 5));
		shapes.add(new Cube(4));
		shapes.add(new Sphere(4));
		for (Shapes3D shape : shapes) {
			System.out.println("Data: " + shape.toString());
			System.out.println("Surface area: " + shape.surfaceArea());
			System.out.println("Volume " + shape.volume());
			System.out.println(" ");
		}
	}

}
