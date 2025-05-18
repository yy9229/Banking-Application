package BankApp;

import java.util.*;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    private static int bankCounter = 1;
    protected String bankCode;
    protected List<Account> accounts = new ArrayList<>();

    public Account findAccount1(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }


    public abstract void openAccount(Account account);
    public abstract void displayBankInfo();

    public Account findAccount(String accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }
}
