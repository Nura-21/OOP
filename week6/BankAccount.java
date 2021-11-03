public class BankAccount {
    private String number;
    private String status;
    private Client owner;

    public BankAccount(String number, String status, Client owner) {
        this.number = number;
        this.status = status;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public Client getOwner() {
        return owner;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
