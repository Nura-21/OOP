package third;

public class Tester {

	public static void main(String[] args) {
		Knight p = new Knight();
		Position a = new Position('d', '4');
		Position b = new Position('f', '5');
		System.out.println(a.x + " " + a.y);
		System.out.println(b.x + " " + b.y);
		System.out.println(p.isLegalMove(a, b));
	}

}
