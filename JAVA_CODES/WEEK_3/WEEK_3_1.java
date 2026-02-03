import java.util.Scanner;


class STUDENT {
    String sname;
    float[] marks_array;
    float total;
    float avg;
    public STUDENT(String sname,float[] marks_array,float total,float avg){
        this.sname=sname;
        this.marks_array=marks_array;
        this.total=total;
        this.avg=avg;
    }
    
}

public class WEEK_3_1{
    public static void main(String[] args) {
        STUDENT objector=new STUDENT(null, null, 0, 0);

        assign(objector);
        compute(objector);
        display(objector);
    }

    public static void assign(STUDENT objector){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Student Name : ");
        objector.sname=sc.nextLine();

        System.out.println("How many Subjects : ");
        int n=sc.nextInt();
        
        objector.marks_array=new float[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Marks " + (i+1) + " : ");
            objector.marks_array[i]=sc.nextFloat();
        }

        sc.close();
        
        return;
    }

    public static void compute(STUDENT objector){
        for (int i = 0; i < objector.marks_array.length; i++) {
            objector.total=objector.total+objector.marks_array[i];
            objector.avg=objector.avg+objector.marks_array[i];
        }

        objector.avg=objector.avg/objector.marks_array.length;

        return;
    }

    public static void display(STUDENT objector){
        System.out.println("Student Name : " + objector.sname);
        System.out.println("Total Marks : " + objector.total);
        System.out.println("Average Marks : " + objector.avg);

        for (int i = 0; i < objector.marks_array.length; i++) {
            System.out.print(objector.marks_array[i]+"  ");
        }
    }
}