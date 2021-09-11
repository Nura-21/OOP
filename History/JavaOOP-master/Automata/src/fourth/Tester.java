package fourth;

public class Tester {

	public static void main(String[] args) {

		CheckingAccount chA = new CheckingAccount(12345678, 2);
		SavingsAccount svA = new SavingsAccount(10203040, 0.1);
		Bank.openBankAccount(chA);
		Bank.openBankAccount(svA);

		chA.deposit(10000.0);
		chA.deposit(10000.0);
		chA.deposit(10000.0);
		chA.transfer(10000.0, svA);

		for (Account acc : Bank.accs) {
			System.out.println(acc);
			System.out.println(" ");
		}
		Bank.update();
		for (Account acc : Bank.accs) {
			System.out.println(acc);
			System.out.println(" ");
		}

		Bank.closeBankAccount(svA);
		System.out.println(" ");
		for (Account acc : Bank.accs) {
			System.out.println(acc);
			System.out.println(" ");
		}

	}
}