package OOPS_LAB.WEEK_9.edu.manipal.mahe.employee;

public class employee {
    private int employeeId;
    private String name;
    protected int age;
    public double basicSalary;

    public employee(int employeeId, String name, int age, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}
