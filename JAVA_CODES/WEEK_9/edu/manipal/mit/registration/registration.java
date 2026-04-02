package OOPS_LAB.WEEK_9.edu.manipal.mit.registration;
import OOPS_LAB.WEEK_9.edu.manipal.mit.course.course;
import OOPS_LAB.WEEK_9.edu.manipal.mit.student.student;

public class registration {
    private student student;
    private course course;

    public registration(student student, course course) {
        this.student = student;
        this.course = course;
    }

    public void registerStudent(){
        System.out.println("Registering " + student.getName() + " for " + course.getCourseName());
    }
}
