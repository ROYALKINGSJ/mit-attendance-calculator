package OOPS_LAB.WEEK_9.edu.manipal.mahe.payroll;

import OOPS_LAB.WEEK_9.edu.manipal.mahe.employee.employee;
import OOPS_LAB.WEEK_9.edu.manipal.mahe.department.department;

public class payroll {
    private employee employee;
    private department department;

    public payroll(employee employee, department department) {
        this.employee = employee;
        this.department = department;
    }

    private double calculateNetSalary(){
        double DA=0.52*employee.getBasicSalary();
        double Gross_Salary=employee.getBasicSalary()+DA;
        double IT=0.3*Gross_Salary;
        double Net_Salary=Gross_Salary-IT;
        return Net_Salary;
    }

    public void generatePaySlip(){
        System.out.println("Employee Name : " + employee.getName());
        System.out.println("Age : " + employee.getAge());
        System.out.println("Department : " + department.getDepartmentName());
        System.out.println("Net Salary : " + calculateNetSalary());
    }
}
