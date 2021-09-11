package third;

public class Pawn extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if (!Piece.limit(a, b))
			return false;
		if (a.y != (b.y - 1))
			return false;
		if (a.x != b.x)
			return false;
		return true;
	}
}
