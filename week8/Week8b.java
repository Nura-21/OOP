public class Week8b{
	public static void main(String[] args) {		

		Fruit f = new Fruit();
		//f.printFruit();
		//System.out.println(f.toString());

		Apple a = new Apple();
		//a.printFruit();
		//System.out.println(a.toString());

		Fruit f2 = new Apple();
		//Apple a2 = new Fruit();
		//System.out.println(f2.eat());

		Banana b = new Banana();

		Fruit[] fruits = {f, a, f2, b, new Apple(), new Orange()};
		for(Fruit fruit: fruits)
			fruit.eat();
	}
}

class Fruit{	// extends Object
	void printFruit(){
		System.out.println("This is a Fruit");
	}

	public String toString(){
		return "This is an Fruit";
	}

	void eat(){
		System.out.println("Eating a fruit ...");
	}
}

class Apple extends Fruit{
	@Override
	void printFruit(){
		super.printFruit();
		System.out.println("This is a Apple");
	}

	public String toString(){
		return "This is an Apple";
	}

	void eat(){
		System.out.println("Eating an apple ...");
	}
} 

class Banana extends Fruit{
	void eat(){
		System.out.println("Eating a banana ...");
	}
}

class Orange extends Fruit{}

