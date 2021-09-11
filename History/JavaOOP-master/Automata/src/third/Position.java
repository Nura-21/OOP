package third;

public class Position {
	public int x;
	public int y;

	public Position() {
		x = 0;
		y = 0;
	}

	public Position(char x, char y) {
		this.x = (int) x - 96;
		this.y = (int) y - 48;

	}

}
