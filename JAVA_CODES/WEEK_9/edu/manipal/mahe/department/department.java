package OOPS_LAB.WEEK_9.edu.manipal.mahe.department;

public class department {
    private String departmentName;
    protected String manager;
    public String location;

    public department(String departmentName, String manager, String location) {
        this.departmentName = departmentName;
        this.manager = manager;
        this.location = location;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManager() {
        return manager;
    }

    public String getLocation() {
        return location;
    }
}
