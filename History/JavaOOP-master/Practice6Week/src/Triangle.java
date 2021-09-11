
public class Triangle extends Shape {

	public Triangle(Color color, int pos) {
		super(color, pos);
	}

	public void draw() {
		if (color == Color.Black)
			System.out.println(super.space() + "<|");
		else
			System.err.println(super.space() + "<|");
	}

}