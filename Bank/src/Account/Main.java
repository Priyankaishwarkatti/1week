package Account;

public class Main {
    public static void main(String[] args) {
        // Creating a customer
        Customer customer1 = new Customer("Priyanka", "ABC11");

        // Creating an account for the customer
        Account account1 = new Account("AB123", customer1);

        // Display customer information
        System.out.println("Customer Name: " + account1.getCustomer().getName());
        System.out.println("Account Number: " + account1.getCustomer().getAccountNumber());

        // Perform deposit and withdrawal
        account1.deposit(1000);
        System.out.println("Balance: " + account1.getBalance());

        account1.withdraw(300);
        System.out.println("Balance: " + account1.getBalance());

        account1.withdraw(300); // This should display an error message
    }
}