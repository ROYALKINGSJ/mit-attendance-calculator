package OOPS_LAB.WEEK_7;

class Account{
    String customer_name;
    long acc_no;
    String acc_type;
    float balance;

    Account(String customer_name,long acc_no,String acc_type,float balance){
        this.customer_name=customer_name;
        this.acc_no=acc_no;
        this.acc_type=acc_type;
        this.balance=balance;
    }

    void display(){
        System.out.println("--- "+acc_type+" Account Details ---");
        System.out.println("Customer Name : "+customer_name);
        System.out.println("Account Number : "+acc_no);
        System.out.println("Account Type : "+acc_type);
        System.out.println("Balance : "+balance);
        System.out.println("--- --- --- --- --- --- --- ---");
    }

    void deposit(float deposit){
        this.balance+=deposit;
    }

    void withdraw(float withdraw){
        if (balance>=withdraw){
            this.balance-=withdraw;
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
}

class current_account extends Account{
    float min_acc_balance=1000;
    float service_tax=100F;

    current_account(String customer_name,long acc_no,String acc_type,float balance){
        super(customer_name, acc_no, acc_type,balance);
    }

    void check_balance(){
        if (this.balance<this.min_acc_balance){
            if (this.balance>this.service_tax){
                this.balance-=this.service_tax;
                System.out.println("Service tax deducted from balance");
            }
            else{
                System.out.println("Balance is insufficient to charge Service tax");
                System.out.println("Account Suspended");
            }
        }
        else{
            System.out.println("Balance is sufficient");
            System.out.println("Minimum Balance is maintained");
        }
    }
}

class savings_bank_account extends Account{
    float interest_rate=0.06F;

    savings_bank_account(String customer_name,long acc_no,String acc_type,float balance){
        super(customer_name, acc_no, acc_type,balance);
    }

    void compute_interest(){
        this.balance+=this.balance*this.interest_rate;
    }
}

public class WEEK_7_4 {
    public static void main(String[] args) {
        current_account obj_1=new current_account("Sanskar Jaiswal", 12345, "Current", 12000);

        savings_bank_account obj_2=new savings_bank_account("Annant Jeet Singh", 32873, "Savings", 32000);

        obj_1.display();
        obj_1.deposit(1000);
        obj_1.withdraw(5000);
        obj_1.check_balance();
        obj_1.display();

        obj_2.display();
        obj_2.deposit(1000);
        obj_2.withdraw(5000);
        obj_2.compute_interest();
        obj_2.display();
    }
}