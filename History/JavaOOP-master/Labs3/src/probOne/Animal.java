package probOne;

public  class Animal {
	private int age;
	private String gender; // M F
	
	public Animal() {
		age = -1;
		gender = "Undefined";
	}
	public Animal(int age,String gender) {
		this.age = age;
		this.gender = gender;
	}
	
	public  String getVoice() {
		return "Undefined";
	};
	
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String toString() {
		return "Age: " + age
			+ "\nGender: " + gender + "\n";
	}
	
}
