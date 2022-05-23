package company;

import java.util.ArrayList;

public class BankDatabase {
    ArrayList<BankAccount> accountList;

    public BankDatabase(ArrayList<BankAccount> accountList) {
        this.accountList = accountList;
    }

    public BankAccount getAccountByID(int id) {
        for (BankAccount account : accountList) {
            if (account.getAccountID() == id) {
                return account;
            }
        }
        return null;
    }
}
