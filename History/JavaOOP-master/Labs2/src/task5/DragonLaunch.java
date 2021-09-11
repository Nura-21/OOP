package task5;

import java.util.Vector;

public class DragonLaunch {
	public Vector<Person> people = new Vector<Person>();
	public Vector<Person> food =  new Vector<Person>();
	
	
	public DragonLaunch() {
	}
	public DragonLaunch(Vector<Person> people) {
		this.people = people;
	}
	
//	public void test() {
//		System.out.println(food.capacity());
//	}
	
	public void kidnap(Person p) {
		people.addElement(p);
		analyzeIt(p);
	}
	public void analyzeIt(Person p) {
		if(p.getGender()==Gender.Boy)
				food.addElement(p);
		else if(p.getGender()==Gender.Girl) {
			if(!food.isEmpty() && (food.lastElement().getGender() == Gender.Boy))
				food.removeElement(food.lastElement());		
			else
				food.addElement(p);
			}
	}
	public void willDragonEatOrNot() {
		if(food.isEmpty())
			System.out.println("Dragon will not eat, poor dragon:(");
		else {
			System.out.println("Dragon will eat(muhahahhaha):");
			for(Person person: food) {
				System.out.println(person);
			}
		}		
			
	}
}
