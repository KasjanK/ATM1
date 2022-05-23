package company;

public class Bank {
    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    public static double minWithdrawAmount = 10.00;
    public static double maxWithdrawAmount = 500.00;

    public int totalAttempts = 3;

    public void withdrawAmount(int accountID, double amount) {
        BankAccount bankAccount = bankDatabase.getAccountByID(accountID);
        double balance = bankAccount.getBalance();

        if (amount < minWithdrawAmount) {
            throw new IllegalArgumentException("The minimum amount is 10.");
        }

        if (amount > maxWithdrawAmount) {
            throw new IllegalArgumentException("The maximum amount is 500.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Not enough funds");
        }

        balance = balance - amount;

        bankAccount.setBalance(balance);
    }

    public double checkBalance(int accountID) {
        BankAccount bankAccount = bankDatabase.getAccountByID(accountID);
        return bankAccount.getBalance();
    }

    public void addAmount(int accountID, double amount) {
        BankAccount bankAccount = bankDatabase.getAccountByID(accountID);
        if (bankAccount.isLoggedIn()) {
            double balance = bankAccount.getBalance();

            if (amount < 0.0d) {
                System.out.println("You can't add negative amounts");
            }

            balance = balance + amount;

            bankAccount.setBalance(balance);
        } else {
            System.out.println("You are not logged in!");
        }
    }

    public void executeLogin(int accountID, int pin) {
        BankAccount bankAccount = bankDatabase.getAccountByID(accountID);

        if (totalAttempts > 0) {
            if (pin == bankAccount.getPin()) {
                bankAccount.setLoggedIn(true);
                System.out.println("Welcome");
            } else {
                System.out.println("Incorrect");
                totalAttempts--;
            }
        } else {
            System.out.println("Maximum number of attempts exceeded");
            bankAccount.setLocked(true);
        }
    }
}
