package fourth;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(int accNumber, double interestRate) {
		super(accNumber);
		this.interestRate = interestRate;
	}

	public void addInterest() {
		deposit(getBalance() * interestRate);
	}

	public String toString() {
		return super.toString() + "\nSavingsAccount: Interest rate: " + interestRate ;
	}

}
