package fourth;

public class CheckingAccount extends Account {
	private int cntTransactions;
	private final int FREE_TRANSACTIONS;

	public CheckingAccount(int accNumber, int FREE_TRANSACTIONS) {
		super(accNumber);
		this.FREE_TRANSACTIONS = FREE_TRANSACTIONS;
	}

	public int getCntTransactions() {
		return this.cntTransactions;
	}

	public void deductFee() {
		this.cntTransactions++;
		if (this.FREE_TRANSACTIONS < this.cntTransactions)
			super.withdraw(0.02);
	}

	public void deposit(double sum) {
		super.deposit(sum);
		this.deductFee();
	}

	public void withdraw(double sum) {
		super.withdraw(sum);
		this.deductFee();
	}

	public String toString() {
		return super.toString() + "\nChecking Account: Transactions count: " + cntTransactions + ". Free transactions: "
				+ FREE_TRANSACTIONS;
	}
}
