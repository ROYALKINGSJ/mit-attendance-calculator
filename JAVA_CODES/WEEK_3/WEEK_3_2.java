import java.util.Scanner;

public class WEEK_3_2 {
    String ename;
    int eid;
    float basic;
    float da;
    float gross_sal;
    float net_sal;

    public WEEK_3_2(String ename, int eid, float basic, float da, float gross_sal, float net_sal){
        this.ename=ename;
        this.eid=eid;
        this.basic=basic;
        this.da=da;
        this.gross_sal=gross_sal;
        this.net_sal=net_sal;
    }
}

class EMPLOYEE{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        
        System.out.println("How many Employees : ");
        int n=sc.nextInt();

        sc.close();
        
        WEEK_3_2[] objector = new WEEK_3_2[n];

        for (int i=0;i<n;i++){
            objector[i] = new WEEK_3_2(null, 0, 0, 0, 0, 0);
            read(objector[i],i);
            compute_net_salary(objector[i],i);
            display(objector[i],i);
        }
    }

    public static void read(WEEK_3_2 objector,int i){

        Scanner sc=new Scanner(System.in);
        System.out.println("\n***** Employee "+(i+1)+" Details *****\n");

        System.out.println("Employee Name : ");
        objector.ename=sc.nextLine();
        System.out.println("Employee ID : ");
        objector.eid=sc.nextInt();
        System.out.println("Employee Basic Salary : ");
        objector.basic=sc.nextFloat();

        System.out.println("***** ***** *****");

        sc.close();

        return;
    }

    public static void compute_net_salary(WEEK_3_2 objector,int i){
        
        objector.da=objector.basic*0.52f;
        objector.gross_sal=objector.basic+objector.da;
        objector.net_sal=objector.gross_sal*0.7f;

        return;
    }

    public static void display(WEEK_3_2 objector,int i){

        System.out.println("Name         : "+objector.ename);
        System.out.println("ID           : "+objector.eid);
        System.out.println("Basic Salary : "+objector.basic);
        System.out.println("DA           : "+objector.da);
        System.out.println("Gross Salary : "+objector.gross_sal);
        System.out.println("Net Salary   : "+objector.net_sal);
        System.out.println("***** ***** *****\n\n");

        return;
    }
}