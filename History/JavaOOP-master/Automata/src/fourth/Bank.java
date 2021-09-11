package fourth;

import java.util.*;

public class Bank {
	static Vector<Account> accs = new Vector<Account>();

	public static void openBankAccount(Account account) {
		accs.add(account);
		System.out.println("Account was created.");
	}

	public static void closeBankAccount(Account account) {
		accs.remove(account);
		System.out.println("Account was deleted.");

	}

	public static void update() {
		for (Account acc : accs) {
			if (acc instanceof SavingsAccount)
				((SavingsAccount) acc).addInterest();
			if (acc instanceof CheckingAccount)
				((CheckingAccount) acc).deductFee();
		}
	}
}