
public abstract class Shape {
	public Color color;
	public int pos;

	public Shape() {
		color = Color.Black;
		pos = 0;
	};

	public Shape(Color color, int pos) {
		this.color = color;
		this.pos = pos;
	};
//	public Color getColor() {
//		return color;
//	}
//	public int getPos() {
//		return pos;
//	}

	public abstract void draw();

	// ci.draw(3);
	public void draw(int n) {
		for (int i = 0; i < n; i++)
			draw();
	}

	public String space() {
		String res = "";
		for (int i = 0; i < pos; i++)
			res += " ";
		return res;
	}

}
