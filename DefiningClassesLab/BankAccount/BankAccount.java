package DefiningClassesLab.BankAccount;

public class BankAccount {
    // fields
    private int id;
    private double balance;

        // static so they can be GLOBAL variables
    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    // constructor
    public BankAccount () {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    // mutators
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public int getId() {
        return id;
    }

    // methods
    public void deposit(double money) {
        this.balance += money;
    }




}
