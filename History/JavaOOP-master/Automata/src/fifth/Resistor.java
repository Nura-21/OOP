package fifth;

public class Resistor extends Circuit {
	private double resistance;
	private double pottentialDiff;

	public Resistor(double resistance) {
		this.resistance = resistance;
	}

	@Override
	public double getResistance() {
		return this.resistance;
	}

	@Override
	public double getPotentialDiff() {
		return this.pottentialDiff;
	}

	@Override
	public void applyPotentialDiff(double V) {
		this.pottentialDiff = V;
	}

}
