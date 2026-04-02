package OOPS_LAB.WEEK_9.edu.manipal.mit.course;

public class course {
    private String courseName;
    protected String instructor;
    public int credits;

    public course(String courseName, String instructor, int credits) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }
}
