package Stores;
import Central_Agency.Account;
import Central_Agency.Bank;

public class Employee extends Thread {
    private Bank bank;
    private String name;
    private Store store;
    private Account accountBalance;
    private Account investmentAccount;
    private static final int MAX_ITERACOES = 10;
    
    public Employee(Bank bank, String name, Store store) {
        this.bank = bank;
        this.name = name;
        this.store = store;
        this.accountBalance = new Account("Conta balance de " + name + " da loja " + store, 0);
        this.investmentAccount = new Account("Conta de investment de " + name, 0);
    }
    public String getNome() { 
        return name;
    }

    @Override
    public void run() {
        int iteracoes = 0;
        while (iteracoes < MAX_ITERACOES && !isInterrupted()) {
            try {
                Thread.sleep((long) (Math.random() * 4000 + 1000)); 
                bank.transfermoney(store.getAccount(), accountBalance, 1400);
                double investment = 0.2 * 1400;
                if (accountBalance.getBalance() >= 1400) { 
                    bank.transfermoney(accountBalance, investmentAccount, investment);
                    System.out.println(name + " obteve R$" + investment + " na conta de investment.");
                } else {
                }
                iteracoes++;
            } catch (InterruptedException e) {
                System.err.println(name + " interrompido durante o processo.");
                interrupt(); 
            }
        }
        System.out.println(name + " finalizou a tarefa.");
    }
    

    public Account getaccountBalance() {
        return accountBalance;
    }
}