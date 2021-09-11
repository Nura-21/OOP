package task5;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Dmitry",19,Gender.Boy);
		Person p2 = new Person("Ariana",18,Gender.Girl);
		Person p3 = new Person("Ivan",19,Gender.Boy);
		Person p4 = new Person("Vika",19,Gender.Girl);
		Person p5 = new Person(Gender.Boy);
		Person p6 = new Person(Gender.Girl);
		
		DragonLaunch dr = new DragonLaunch();
		dr.kidnap(p2);
		dr.kidnap(p4);
		dr.kidnap(p6);
		dr.kidnap(p1);
		dr.kidnap(p3);
		dr.kidnap(p5);
		System.out.println("First dragon: ");
		dr.willDragonEatOrNot();
		
		DragonLaunch dr2 = new DragonLaunch();
		dr2.kidnap(p1);
		dr2.kidnap(p3);
		dr2.kidnap(p5);
		dr2.kidnap(p2);
		dr2.kidnap(p4);
		dr2.kidnap(p6);
		System.out.println("Second dragon: ");
		dr2.willDragonEatOrNot();
	}

}
