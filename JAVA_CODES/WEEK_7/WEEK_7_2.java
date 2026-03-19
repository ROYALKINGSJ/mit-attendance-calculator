package OOPS_LAB.WEEK_7;
import java.util.Scanner;

class EMPLOYEE{
    String ename;

    EMPLOYEE(String ename){
        this.ename=ename;
    }

    void calculateSalary(){
        System.out.println("Salary calculated in Parent class");
    }

    void displayEmployeeDetails(){
        System.out.println("Employee Name (in Parent class): "+ename);
    }
}

class FullTimeEmp extends EMPLOYEE{
    int hoursWorked;
    final static double hourlyRate=10;
    double bonus;
    double deductions;

    FullTimeEmp(String ename,int hoursWorked,double bonus,double deductions){
        super(ename);
        this.hoursWorked=hoursWorked;
        this.bonus=bonus;
        this.deductions=deductions;
    }

    void calculateSalary(){
        double salary=hoursWorked*hourlyRate+bonus-deductions;
        System.out.println("Salary of "+ename+" is "+salary);
    }

    void displayEmployeeDetails(){
        System.out.println("Employee Name (in Child class): "+ename);
        System.out.println("Hours Worked: "+hoursWorked);
        System.out.println("Bonus: "+bonus);
        System.out.println("Deductions: "+deductions);
    }
}

class PartTimeEmp extends EMPLOYEE{
    int hoursWorked;
    final static double hourlyRate=10;

    PartTimeEmp(String ename,int hoursWorked){
        super(ename);
        this.hoursWorked=hoursWorked;
    }

    void calculateSalary(){
        double salary=hoursWorked*hourlyRate;
        System.out.println("Salary of "+ename+" is "+salary);
    }

    void displayEmployeeDetails(){
        System.out.println("Employee Name (in Child class): "+ename);
        System.out.println("Hours Worked: "+hoursWorked);
    }
}

public class WEEK_7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EMPLOYEE obj_1=new EMPLOYEE("Sanskar Jaiswal");
        obj_1.calculateSalary();
        obj_1.displayEmployeeDetails();
        System.out.println("**********");


        FullTimeEmp obj_2=new FullTimeEmp("Annant Jeet Singh",10,1000,500);
        obj_2.calculateSalary();
        obj_2.displayEmployeeDetails();
        System.out.println("**********");



        PartTimeEmp obj_3=new PartTimeEmp("Atisha Mishra",10);
        obj_3.calculateSalary();
        obj_3.displayEmployeeDetails();
        System.out.println("**********");


        sc.close();
    }
}
