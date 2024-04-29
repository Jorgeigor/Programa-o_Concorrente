package Central_Agency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Bank {
    private Lock lock = new ReentrantLock();

    public void transfermoney(Account origin, Account destiny, double value) {
        lock.lock();
        try {
            if (origin.getBalance() >= value) {
                origin.debit(value);
                destiny.credit(value);
                System.out.println("Transfer: \n");
                System.out.println("Transfer de R$" + value + " de " + origin.getHolder() + " Destinátario " + destiny.getHolder() + " Concluida.");
                System.out.println("Balance Atualizado: \n");
                System.out.println("Balance de " + origin.getHolder() + ": R$" + origin.getBalance());
                System.out.println("Balance de " + destiny.getHolder() + ": R$" + destiny.getBalance());
            } else if (origin.getBalance() < value) {
                
            }
        } finally {
            lock.unlock();
        }
    }
}
