package OOPS_LAB.WEEK_9.edu.manipal.mit.student;

public class student {
    private String name;
    private int rollNumber;
    protected String department;
    public double gpa;

    public student(String name, int rollNumber, String department, double gpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }
}