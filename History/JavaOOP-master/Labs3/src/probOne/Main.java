package probOne;

public class Main {

	public static void main(String[] args) {
		Animal a1 = new Animal(7,"M");
		Doge d1 = new Doge(3,"F","Ball");

		System.out.println(a1.getVoice());
		System.out.println(a1.toString());
		
		System.out.println(d1.getVoice());
		System.out.println(d1.getVoice(8));
		System.out.println(d1.toString());
	}

}
