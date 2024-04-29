package Central_Agency;

public class Account {
    private String holder;
    private double balance;

    public Account(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public void credit(double value) {
        balance += value;
    }

    public void debit(double value) {
        balance -= value;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }
}