import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int money = in.nextInt();
		double percent = in.nextInt();
		System.out.println(money + (money * (percent / 100)));
		in.close();
	}

}