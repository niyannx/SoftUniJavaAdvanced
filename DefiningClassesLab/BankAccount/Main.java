package DefiningClassesLab.BankAccount;

/*
Create class BankAccount.
The class should have private fields for:
•	Id: int (Starts from 1 and increments for every new account)
•	Balance: double
•	Interest rate: double (Shared for all accounts. Default value: 0.02)
The class should also have public methods for:
•	setInterestRate(double interest): void (static)
•	getInterest(int Years): double
•	deposit(double amount): void
Create a test client supporting the following commands:
•	Create
•	Deposit {Id} {Amount}
•	SetInterest {Interest}
•	GetInterest {ID} {Years}
•	End

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            String result = "";

            switch (commands[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);

                    result = String.format("Account ID%d created", account.getId());
                    break;
                case "Deposit":
                    int accountID = Integer.parseInt(commands[1]);
                    double money = Double.parseDouble(commands[2]);

                    if (accounts.containsKey(accountID)) {
                        BankAccount bankAccountFromMap = accounts.get(accountID);
                        bankAccountFromMap.deposit(money);
                        accounts.put(accountID, bankAccountFromMap);

                        result = String.format("Deposited %.0f to ID%d", money, accountID);
                    } else {
                        result = "Account does not exist";
                    }

                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commands[1]);

                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int currAccountID = Integer.parseInt(commands[1]);
                    int years = Integer.parseInt(commands[2]);

                    if (accounts.containsKey(currAccountID)) {
                        BankAccount account1 = accounts.get(currAccountID);
                        double totalInterest = account1.getInterest(years);

                        result = String.format("%.2f", totalInterest);
                    } else {
                        result = "Account does not exist";
                    }

                    break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }

            input = scan.nextLine();
        }
    }
}
