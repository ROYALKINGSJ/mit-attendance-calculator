package OOPS_LAB.WEEK_4;

class BankAccount{
    String depositorName;
    long accountNumber;
    String accountType;
    double balance;
    static double interestRate=0.05;

    BankAccount() {
        this.depositorName = "Sanskar Jaiswal";
        this.accountNumber = 123456789L;
        this.accountType = "Savings";
        this.balance = 5000.0;
    }

    BankAccount(String name, long accNo, String type, double bal) {
        this.depositorName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.balance = bal;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount>0 && amount<=balance && (balance-amount)>=1000) {
            balance -= amount;
            System.out.println("Amount withdrawn : " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void display() {
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    static void displayInterestRate() {
        System.out.println("Interest Rate: " + interestRate);
    }
}

public class WEEK_4_3 {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Annantjeet Singh", 987654321L, "Current", 10000.0);

        System.out.println("--- Account 1 Details ---");
        acc1.display();
        acc1.deposit(1500);
        // MINIMUM ACCOUNT BALANCE IS 1000
        acc1.withdraw(2000);
        acc1.display();
        acc1.displayInterestRate();

        System.out.println("\n--- Account 2 Details ---");
        acc2.display();
        acc2.deposit(5000);
        // MINIMUM ACCOUNT BALANCE IS 1000
        acc2.withdraw(3000);
        acc2.display();
        acc2.displayInterestRate();
    }
}