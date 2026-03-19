package OOPS_LAB.WEEK_7;
import java.util.Scanner;

class STUDENT{
    String name;
    int marks_1,marks_2;
    float total,avg;

    STUDENT(String name,int m1,int m2){
        this.name=name;
        this.marks_1=m1;
        this.marks_2=m2;
    }
    
    void compute(){
        total=marks_1+marks_2;
        avg=total/2;
    }
}

class ScienceStudent extends STUDENT{
    int practicalMarks;

    ScienceStudent(String name,int marks_1,int marks_2,int practicalMarks){
        super(name, marks_1, marks_2);
        this.practicalMarks=practicalMarks;
    }

    void displayAll(){
        System.out.println("Your Name : "+name);
        System.out.println("Your Practical Marks : "+practicalMarks);
    }

    void displayPracticalMarks(){
        System.out.println("Your Practical Marks : "+practicalMarks);
    }
}

class ArtsStudent extends STUDENT{
    String electiveSubject;

    ArtsStudent(String name,int marks_1,int marks_2,String electiveSubject){
        super(name, marks_1, marks_2);
        this.electiveSubject=electiveSubject;
    }

    void displayAll(){
        System.out.println("Your Name : "+name);
        System.out.println("Your Elective Subject : "+electiveSubject);
    }
}

public class WEEK_7_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Name : ");
        String name=sc.nextLine();
        System.out.println("Marks 1 :");
        int marks_1=sc.nextInt();
        System.out.println("Marks 2 :");
        int marks_2=sc.nextInt();

        System.out.println("Which Student ?");
        System.out.println("1.ScienceStudent");
        System.out.println("2.ArtsStudent");
        int choice=sc.nextInt();

        if (choice==1){
            System.out.println("Enter Practical Marks : ");
            int pm=sc.nextInt();

            ScienceStudent obj=new ScienceStudent(name,marks_1,marks_2,pm);

            obj.compute();
            obj.displayAll();
            obj.displayPracticalMarks();
        }
        else if (choice==2){
            System.out.println("Enter Elective Subject : ");
            String es=sc.nextLine();

            ArtsStudent obj=new ArtsStudent(name,marks_1,marks_2,es);

            obj.compute();
            obj.displayAll();
        }

        sc.close();
    }
}