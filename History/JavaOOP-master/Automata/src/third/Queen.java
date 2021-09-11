package third;

public class Queen extends Piece {

	@Override
	public boolean isLegalMove(Position a, Position b) {
		return (new Rook()).isLegalMove(a, b) || (new Bishop().isLegalMove(a, b));
	}

}
