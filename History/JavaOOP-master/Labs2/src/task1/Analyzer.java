package task1;
import java.util.Scanner;

public class Analyzer {
	Analyzer(){}
	void start() {
		Data d = new Data();
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("Enter number (Q - quit): ");
			String s = in.nextLine();
			if(s.equals("Q"))
				break;
			d.addValue(Integer.parseInt(s));
		}
		System.out.println("Average - "+d.getAverage());
		System.out.println("Largest - "+d.getLargest());
		in.close();
	}
}
