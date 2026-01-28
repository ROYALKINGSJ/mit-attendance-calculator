package OOPS_LAB;
import java.util.Scanner;

public class WEEK_2_2 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Registration Number : ");
        int registration_number=sc.nextInt();
        
        registration_number=registration_number/10000000;

        System.out.println("Year of Joining is : 20" + registration_number);
        sc.close();
    }
}
