class House{
	int numOfFloors;
	int area;
	String colour;
	static String streetName = "Tole bi";

	static int streetcounter = 0;
	static int cnt = 0;

	House(int a, String col, int n){
		area = a;
		numOfFloors = n;
		colour = col; // TASK 1
		cnt++;
		streetcounter++;
	}

	void showArea(){
		System.out.println("Area : " + area);
	}

	// TASK 2
	void changeColor(String new_colour){
		colour = new_colour;
	}

	void changenumofloors(int new_num){
		numOfFloors = new_num;
	}

	void showcolour(){
		System.out.println("Color : " + colour);
	}

	void showfloor(){
		System.out.println("Number of floors : " + numOfFloors);
	}

	static void showStreetName(){
		System.out.println("Street : " + streetName + " " + streetcounter);
	}

	static void showTotalNumberOfHouses(){
		System.out.println("Total number of Houses : " + cnt);
	}

	static void generateAddresses(int numofadd){
		for(int i = 0; i < numofadd; ++i){
			streetcounter++;
			showStreetName();
		}
	}

	// TASK-1: Add at least one more instance data field;

	// TASK-2: Add at least one more instance method;	

	// TASK-3: Create a method showTotalNumberOfHouses();

	// TASK-4: Generate Addresses (Street numbers) automatically (Ex: Abylai khan 1, Abylai khan 2, etc.).
}

public class W3b{
	public static void main(String[] args) {

		House.showTotalNumberOfHouses();

		House h1 = new House(50, "White", 5);

		System.out.println("First House: ");
		h1.showcolour();
		h1.showArea();
		h1.showfloor();
		House.showStreetName();

		System.out.println();
		House.showTotalNumberOfHouses();

		House h2 = new House(120, "Brown", 5);

		System.out.println();

		System.out.println("Second House: ");
		h2.showcolour();
		h2.showArea();
		h2.showfloor();
		House.showStreetName();
		
		System.out.println();
		House.showTotalNumberOfHouses();
		System.out.println();

		int numofadd = 10;
		House.generateAddresses(numofadd);
	}
}