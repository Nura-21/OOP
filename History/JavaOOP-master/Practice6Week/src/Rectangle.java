
public class Rectangle extends Shape {
	public int side;

	public Rectangle(Color color, int pos) {
		super(color, pos);
		side = 5;
	}

	public Rectangle(Color color, int pos, int side) {
		super(color, pos);
		this.side = side;
	}

	public void draw() {
		if (color == Color.Black)
			System.out.println(super.space() + "[]");
		else
			System.err.println(super.space() + "[]");
	}

	public int getRectArea() {
		return side * side;
	}
}
