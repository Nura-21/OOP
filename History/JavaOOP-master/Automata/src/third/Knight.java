package third;

public class Knight extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if (!Piece.limit(a, b))
			return false;

		if ((a.x - 1 == b.x || a.x + 1 == b.x) && (a.y - 2 == b.y || a.y + 2 == b.y))
			return true;
		else if ((a.y - 1 == b.y || a.y + 1 == b.y) && (a.x - 2 == b.x || a.x + 2 == b.x))
			return true;
		return false;
	}

}
