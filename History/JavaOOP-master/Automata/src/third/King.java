package third;

public class King extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if (!Piece.limit(a, b))
			return false;
		if (!((b.x == a.x + 1 || b.x == a.x - 1 || b.x == a.x) && (b.y == a.y + 1 || b.y == a.y - 1 || b.y == a.y)))
			return false;
		return true;
	}

}
