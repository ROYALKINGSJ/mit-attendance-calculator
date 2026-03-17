package OOPS_LAB.WEEK_6;
import java.util.Scanner;

class ServiceRequest{
    String[] request;
    String[] sr_date;

    static void displayByMonth(int n,String[] request,String[] sr_date){
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (((sr_date[j]).substring(3,6)).compareToIgnoreCase(sr_date[j+1].substring(3,6))>0){
                    String temp=sr_date[j];
                    sr_date[j]=sr_date[j+1];
                    sr_date[j+1]=temp;

                    temp=request[j];
                    request[j]=request[j+1];
                    request[j+1]=temp;
                }
            }
        }
    }
}

public class WEEK_6_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Number of Requests : ");
        int n=sc.nextInt();
        sc.nextLine();

        ServiceRequest obj=new ServiceRequest();
        obj.request=new String[n];
        obj.sr_date=new String[n];

        for (int i=0;i<n;i++){
            System.out.println("***** ***** *****");
            System.out.print("Service Request : ");
            String request=sc.nextLine();

            System.out.print("Service Request Date (DD-MMM-YYYY): ");
            String sr_date=sc.nextLine();

            obj.request[i]=request;
            obj.sr_date[i]=sr_date;
            System.out.println("***** ***** *****");
        }

        ServiceRequest.displayByMonth(n, obj.request, obj.sr_date);

        for (int i=0;i<n;i++){
        System.out.println("***** Service "+(i+1)+" *****");
            System.out.println("Service Request : "+obj.request[i]);
            System.out.println("Service Request Date : "+obj.sr_date[i]);
            System.out.println("***** ***** *****");
        }

        sc.close();
    }
}