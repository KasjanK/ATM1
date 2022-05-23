package company;

public class BankAccount {
    private int accountID;
    private int pin;
    private boolean isLocked;
    private double balance;
    private static String bank;
    private boolean isLoggedIn;

    public BankAccount(int accountID, int pin, boolean isLocked, double balance, String bank, boolean isLoggedIn) {
        this.accountID = accountID;
        this.pin = pin;
        this.isLocked = isLocked;
        this.balance = balance;
        this.isLoggedIn = isLoggedIn;
        this.bank = bank;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static String getBank() {
        return bank;
    }

    public static void setBank(String bank) {
        BankAccount.bank = bank;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public static String bankName() {
        return getBank();
    }

    @Override
    public String toString() {
        return this.accountID + " - " + this.pin + " - " + this.isLocked + " - " + this.balance + " - " + this.bank;
    }
}
