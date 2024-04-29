package Stores;
import Central_Agency.Account;
import Central_Agency.Bank;

public class Client extends Thread {
    private Bank bank;
    private String name;
    private Store[] stores;
    private Employee[] employees;
     

    public Client(Bank bank, String name, Store[] stores, Employee[] employees) { 
        this.bank = bank;
        this.name = name;
        this.stores = stores;
        this.employees = employees; 
    }

    @Override
    public void run() {
        Account conta = new Account("Conta do " + name, 1000);
        while (conta.getBalance() > 0) {
            try {
                Thread.sleep((long) (Math.random() * 2000 + 1000)); 
                Store store = stores[(int) (Math.random() * stores.length)];
                double value = (Math.random() < 0.5) ? 100 : 200;
                bank.transfermoney(conta, store.getAccount(), value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
        for (Employee employee : employees) {
            try {
                employee.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}