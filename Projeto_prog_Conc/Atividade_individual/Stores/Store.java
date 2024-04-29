package Stores;
import Central_Agency.Account;
import Central_Agency.Bank;

public class Store {
    private Bank bank;
    private String name;
    private Account account;

    public Store(Bank banco, String nome) {
        this.bank = banco;
        this.name = nome;
        this.account = new Account("Conta da loja " + name, 0);
    }

    public void paySalary(Employee[] employees) {
        double totalSalarios = employees.length * 1400;
        if (account.getBalance() >= totalSalarios) {
            for (Employee employee : employees) {
                bank.transfermoney(account, employee.getaccountBalance(), 1400);
            }
            System.out.println("Salários dos funcionários da loja " + name + " foram pagos.");
        } else {
        }
    }
    

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
