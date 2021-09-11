
public class Circle extends Shape {
	public Circle(Color color, int pos) {
		super(color, pos);
	}

	public void draw() {
		if (color == Color.Black)
			System.out.println(super.space() + "O");
		else
			System.err.println(super.space() + "O");
	}

}
