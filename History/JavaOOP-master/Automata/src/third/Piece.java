package third;

public abstract class Piece {
	public abstract boolean isLegalMove(Position a, Position b);

	public static boolean limit(Position a, Position b) {
		if (a.x < 1 || a.y < 1 || b.x < 1 || b.y < 1 || a.x > 8 || a.y > 8 || b.x > 8 || b.y > 8)
			return false;
		if (a.x == b.x && a.y == b.y)
			return false;
		return true;
	}
}
