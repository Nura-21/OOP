import java.util.*;
public class TaskTwo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		System.out.println("Area = " + a*a);
		System.out.println("Perimeter = " + a*4);
		System.out.println("Diagonal = " + Math.pow(a*a+a*a,0.5));
		in.close();
	}

}
