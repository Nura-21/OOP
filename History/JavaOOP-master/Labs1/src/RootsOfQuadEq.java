import java.util.*;

public class RootsOfQuadEq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = b * b - 4 * a * c;
		if (d < 0)
			System.out.println("D<0");
		else if (d == 0)
			System.out.println(-b / (2 * a));
		else
			System.out.println((-b + Math.pow(d, 0.5)) / (2 * a) + " " + (-b - Math.pow(d, 0.5)) / (2 * a));
		in.close();
	}

}
