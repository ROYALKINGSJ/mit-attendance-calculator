package OOPS_LAB.WEEK_8;
import java.util.Scanner;

interface Series{
    void getNext(Scanner sc);
    void reset(Scanner sc);
    void setStart(Scanner sc);
}

class ByTwos implements Series{
    long value=0;
    long constant=2;
    public void getNext(Scanner sc){
        System.out.println("Previous Value : "+value);
        value=value+constant;
        System.out.println("Current Value : "+value);
    }
    public void reset(Scanner sc){
        System.out.println("Value Reset Done");
        value=0;
    }
    public void setStart(Scanner sc){
        System.out.println("Enter Starting Value : ");
        value=sc.nextInt();
    }
}

public class WEEK_8_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ByTwos obj=new ByTwos();

        System.out.println("1.Get Next");
        System.out.println("2.Reset");
        System.out.println("3.Set Start");
        System.out.println("4.Exit");
        System.out.println("Enter Choice : ");
        int choice=sc.nextInt();

        while (choice!=4) {
            if (choice==1){
                obj.getNext(sc);
            }
            else if (choice==2){
                obj.reset(sc);
            }
            else if (choice==3){
                obj.setStart(sc);
            }

            System.out.println("1.Get Next");
            System.out.println("2.Reset");
            System.out.println("3.Set Start");
            System.out.println("4.Exit");
            System.out.println("Enter Choice : ");
            choice=sc.nextInt();
        }
    }
}