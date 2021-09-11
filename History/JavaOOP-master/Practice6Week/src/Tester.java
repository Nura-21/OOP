import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		Vector<Shape> v = new Vector<Shape>();
		v.add(new Circle(Color.Black, 0));
		v.add(new Circle(Color.Red, 5));
		v.add(new Rectangle(Color.Black, 2));
		v.add(new Rectangle(Color.Red, 4));
		v.add(new Triangle(Color.Black, 3));
		v.add(new Triangle(Color.Red, 7));
		for (Shape s : v) {
			s.draw();
		}
//		for(Shape s:v)
//			if(s instanceof Rectangle)
//				System.out.println(((Rectangle)s).getRectArea());
	}

}
