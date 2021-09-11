package taskOne;

public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat(3, Gender.M, "Barsik");
		Car car = new Car("Supra", 300);
		cat.eat();
		car.move();
		cat.move();
		cat.voice();

	}
}
//OUTPUT:
//*Eats*
//*Drives*
//*Moves*
//Meow