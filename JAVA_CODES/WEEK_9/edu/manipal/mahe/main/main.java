package OOPS_LAB.WEEK_9.edu.manipal.mahe.main;

import java.util.Scanner;
import OOPS_LAB.WEEK_9.edu.manipal.mahe.employee.employee;
import OOPS_LAB.WEEK_9.edu.manipal.mahe.department.department;
import OOPS_LAB.WEEK_9.edu.manipal.mahe.payroll.payroll;


public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department Name: ");
        String departmentName = sc.nextLine();

        System.out.print("Enter Department Manager: ");
        String departmentManager = sc.nextLine();

        System.out.println("Enter Department Location: ");
        String departmentLocation = sc.nextLine();

        employee emp_obj = new employee(id, name, age, basicSalary);
        department dept_obj = new department(departmentName, departmentManager, departmentLocation);
        payroll pay = new payroll(emp_obj, dept_obj);

        pay.generatePaySlip();

        sc.close();
    }
}
