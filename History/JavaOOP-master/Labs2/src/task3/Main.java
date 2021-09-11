package task3;

public class Main {

	public static void main(String[] args) {
		Temperature t2 = new Temperature(35.0,Scale.C);
		Temperature t3 = new Temperature(100.0,Scale.F);
			
		System.out.println(t2.getC());
		System.out.println(t2.getF());
		t2.setData(100.0, Scale.F);
		System.out.println(t2.getF());
		System.out.println(t2.getC());
		
		System.out.println();
		
		System.out.println(t3.getF());
		System.out.println(t3.getC());
		t3.setData(200.0, Scale.C);
		System.out.println(t3.getC());
		System.out.println(t3.getF());

	}

}
