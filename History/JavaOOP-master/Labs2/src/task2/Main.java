package task2;

public class Main {

	public static void main(String[] args) {
		StudentsOfKBTU st1 = new StudentsOfKBTU("Ivan", Degree.Bachelor, 3.0);
		StudentsOfKBTU st2 = new StudentsOfKBTU("Egor", Degree.Bachelor);
		System.out.println(st1.toString());
		System.out.println(st2.toString());
		
		st1.setInfo(3.0);
		st2.setInfo(3.1, Degree.Master);
		
		System.out.println(st1.getId());
		System.out.println(st1);
		System.out.println(st2);
	}

}
