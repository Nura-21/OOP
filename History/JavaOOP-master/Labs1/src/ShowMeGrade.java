import java.util.Scanner;
public class ShowMeGrade {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		if(a<50)
			System.out.println("F");
		else {
			if(a>=50 && a <=54)
				System.out.println("D");
			else if(a>=55 && a <=59)
				System.out.println("D+");
			else if(a>=60 && a <=64)
				System.out.println("C-");
			else if(a>=65 && a <=69)
				System.out.println("C");
			else if(a>=70 && a <=74)
				System.out.println("C+");
			else if(a>=75 && a <=79)
				System.out.println("B-");
			else if(a>=80 && a <=84)
				System.out.println("B");
			else if(a>=85 && a <=89)
				System.out.println("B+");
			else if(a>=90 && a <=94)
				System.out.println("A-");
			else if(a>=95 && a <=100)
				System.out.println("A");
			else
				System.out.println("Nice joke");
		}
		in.close();
	}

}