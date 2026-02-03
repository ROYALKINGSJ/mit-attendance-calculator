import java.util.Scanner;

public class WEEK_2_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many Years have you already served : ");
        int years_serviced=sc.nextInt();

        System.out.println("Year of Birth : ");
        int year_of_birth=sc.nextInt();

        sc.close();

        System.out.println("You have "+((year_of_birth+60)-(year_of_birth+18+years_serviced))+" years of service left before Retirement(if you joined at the age of 18)");
    }
}
