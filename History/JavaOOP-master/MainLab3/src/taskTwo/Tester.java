package taskTwo;

public class Tester {

	public static void main(String[] args) {
		Car car = new Car("AUDI");
		Cat cat = new Cat("Barsik");
		cat.move();
		car.start();
		car.move();
		car.changeGear();
		car.shutDown();

	}

}
//OUTPUT:
//Cat moves
//Car engine starts...
//Car rides
//Car gear has changed
//Car engine stops...
