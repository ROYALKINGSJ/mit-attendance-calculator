import java.util.Scanner;

class EMPLOYEE{
    String Employee_Name;
    double Employee_Salary;
    Department[] Dept_object;

    class Department{
        String Dept_Name;
        String Dept_Location;

        void set(String Dept_Name,String Dept_Location){
            this.Dept_Name=Dept_Name;
            this.Dept_Location=Dept_Location;
        }

        void display(){
            System.out.println("Department Name : "+this.Dept_Name);
            System.out.println("Department Location : "+this.Dept_Location);
        }
    }

    void add_deparment(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Number Of Departments : ");
        int Number_Of_Departments=sc.nextInt();

        Dept_object=new Department[Number_Of_Departments];

        for (int i=0;i<Number_Of_Departments;i++){
            Dept_object[i]=new Department();

            System.out.println("Enter Department Name : ");
            String Dept_Name=sc.next();

            System.out.println("Enter Department Location : ");
            String Dept_Location=sc.next();

            Dept_object[i].set(Dept_Name, Dept_Location);
        }
    }

    void display_all_details(){
        System.out.println("Employee Name : "+Employee_Name);
        System.out.println("Employee Salary : "+Employee_Salary);
        for (int i=0;i<Dept_object.length;i++){
            Dept_object[i].display();
        }
    }
}

public class WEEK_5_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Number Of Employees : ");
        int Number_Of_Employees=sc.nextInt();

        EMPLOYEE[] Employee_object_array=new EMPLOYEE[Number_Of_Employees];

        for (int i=0;i<Number_Of_Employees;i++){
            Employee_object_array[i]=new EMPLOYEE();

            System.out.println("Enter Employee Name : ");
            Employee_object_array[i].Employee_Name=sc.next();

            System.out.println("Enter Employee Salary : ");
            Employee_object_array[i].Employee_Salary=sc.nextDouble();

            Employee_object_array[i].add_deparment();

            System.out.println("***********************************");

            Employee_object_array[i].display_all_details();
        }
    }
}