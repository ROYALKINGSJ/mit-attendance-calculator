package  OOPS_LAB.WEEK_9.edu.manipal.mit.main;
import java.util.Scanner;

import OOPS_LAB.WEEK_9.edu.manipal.mit.course.course;
import OOPS_LAB.WEEK_9.edu.manipal.mit.registration.registration;
import OOPS_LAB.WEEK_9.edu.manipal.mit.student.student;

public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Manipal Institute of Technology!");

        System.out.println("Student Details:");

        System.out.println("Name : ");
        String name=sc.nextLine();

        System.out.println("Roll Number : ");
        int rollNumber=sc.nextInt();

        System.out.println("Department : ");
        sc.nextLine();
        String department=sc.nextLine();

        System.out.println("GPA : ");
        double gpa=sc.nextDouble();

        student student_obj=new student(name,rollNumber,department,gpa);
        
        System.out.println("***** ***** *****");
        System.out.println("Course Details:");
        System.out.println("Course Name : ");
        sc.nextLine();
        String courseName=sc.nextLine();

        System.out.println("Instructor : ");
        String instructor=sc.nextLine();

        System.out.println("Credits : ");
        int credits=sc.nextInt();

        course course_obj=new course(courseName, instructor, credits);

        System.out.println("***** ***** *****");


        System.out.println("Registering student for the course...");
        registration registration_obj=new registration(student_obj, course_obj);
        registration_obj.registerStudent();

        sc.close();
    }
}
