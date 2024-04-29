import Central_Agency.Bank;
import Stores.Client;
import Stores.Employee;
import Stores.Store;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Store[] stores = {new Store(bank, "Growth"), new Store(bank, "Zara")};
        Employee[] employees = {new Employee(bank, "Beatriz", stores[0]), new Employee(bank, "Fernando", stores[0]),
                new Employee(bank, "Karol", stores[1]), new Employee(bank, "Marcos", stores[1])};
        Client[] clients = {new Client(bank, "Cliente 1", stores, employees), new Client(bank, "Cliente 2", stores, employees),
                new Client(bank, "Cliente 3", stores, employees), new Client(bank, "Cliente 4", stores, employees), new Client(bank, "Cliente 5", stores, employees)};

        for (Employee employee : employees) {
            employee.start();
        }

        for (Client cliente : clients) {
            cliente.start();
        }

        for (Employee employee : employees) {
            try {
                employee.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Client client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Store store : stores) {
            store.paySalary(employees);
        }

    }
}
