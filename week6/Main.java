import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Client client = new Client("87777777777", "11111", "John");
        Client client2 = new Client("87777770000", "00002", "Eva");
        BankAccount account = new BankAccount("111-111-111","NEW", client);
        BankAccount account_old = new BankAccount("111-111-111","OLD", client);
        BankAccount account2 = new BankAccount("111-111-222","NEW", client2);
        BankAccount account2_old = new BankAccount("111-111-222","OLD", client2);

        List<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account_old);
        accounts.add(account2);
        accounts.add(account2_old);

        Bank bank = new Bank(clients, accounts, "AO SomeBank");

        System.out.println(bank.makeReport());

    }
}
