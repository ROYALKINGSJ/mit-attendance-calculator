package OOPS_LAB.WEEK_8;
import java.util.Scanner;

interface Sports{
    void putSportsScore(float sport_score);
}

class Student{
    float marks;
    long rollNum;

    void getRollNum(){
        System.out.println("Roll Number : "+rollNum);
    }

    void putRollNum(long rollNum){
        this.rollNum=rollNum;
    }

     void getMarks(){
        System.out.println("Marks : "+marks);
     }

     void putMarks(float marks){
        this.marks=marks;
     }
}

class Result extends Student implements Sports{
    float sport_score;

    public void putSportsScore(float sport_score){
        this.sport_score=sport_score;
    }

    public void display(){
        System.out.println("Total Score (marks + sports score): "+(sport_score+marks));
    }
}

public class WEEK_8_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Result obj=new Result();

        System.out.println("Enter Roll Number : ");
        obj.putRollNum(sc.nextLong());
        System.out.println("Enter Marks : ");
        obj.putMarks(sc.nextFloat());
        System.out.println("Enter Sport Score : ");
        obj.putSportsScore(sc.nextFloat());

        System.out.println("--- --- ---");
        obj.getRollNum();
        obj.getMarks();
        obj.display();
        System.out.println("--- --- ---");

        sc.close();
    }
}
