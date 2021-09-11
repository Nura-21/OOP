package third;

public class Bishop extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		if (!Piece.limit(a, b))
			return false;
		if (!(Math.abs(a.x - b.x) == Math.abs(a.y - b.y)))
			return false;
		return true;
	}
}
