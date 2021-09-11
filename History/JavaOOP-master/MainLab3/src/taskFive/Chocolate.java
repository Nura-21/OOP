package taskFive;

public class Chocolate implements Comparable {
	private double weight;
	private String name;

	public Chocolate() {
	}

	public Chocolate(double weight, String name) {
		this.weight = weight;
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		Chocolate c = (Chocolate) o;
		if (weight > c.weight)
			return 1;
		if (weight < c.weight)
			return -1;
		return 0;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Chocolate [weight=" + weight + ", name=" + name + "]";
	}

}
