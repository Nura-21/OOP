package fifth;

public class Series extends Circuit {
	private Circuit r1;
	private Circuit r2;

	public Series(Circuit r1, Circuit r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public double getResistance() {
		return r1.getResistance() + r2.getResistance();
	}

	@Override
	public double getPotentialDiff() {
		return r1.getPotentialDiff() + r2.getPotentialDiff();
	}

	@Override
	public void applyPotentialDiff(double V) {
		r1.applyPotentialDiff(V * (r1.getResistance() / getResistance()));
		r2.applyPotentialDiff(V * (r2.getResistance() / getResistance()));
	}

}
