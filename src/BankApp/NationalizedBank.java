package BankApp;

public class NationalizedBank extends Bank {
    public NationalizedBank(String bankName, String branchName) {
        super();
    }

    @Override
    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened successfully at " + bankName);
    }


    @Override
    public void displayBankInfo() {
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + bankCode);
    }
}
