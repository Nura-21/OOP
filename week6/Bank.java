import java.util.List;
public class Bank {
    private List<Client> clients;
    private List<BankAccount> accounts;
    private String name;

    public Bank(List<Client> clients, List<BankAccount> accounts, String name) {
        this.clients = clients;
        this.accounts = accounts;
        this.name = name;
    }

    public void createAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created");
        System.out.println(account.toString());
    }

    public void createClient(Client client) {
        clients.add(client);
        System.out.println("Client created");
        System.out.println(client.toString());
    }

    public String makeReport() {
        for (BankAccount acc : accounts) {
            for (Client client : clients) {
                if(acc.getOwner().getId().equals(client.getId())){
                    System.out.println(client.getName() + " has " + acc.getOwner().getId() + " " + name);
                }
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer countClients() {
        return clients.size();
    }

    public Integer countAccounts() {
        return accounts.size();
    }
}
