package third;

public class Rook extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if (!Piece.limit(a, b))
			return false;
		if ((a.x - b.x) * (a.y - b.y) != 0)
			return false;
		return true;

	}

}
