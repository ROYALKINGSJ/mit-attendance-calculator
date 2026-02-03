import java.util.Scanner;

public class WEEK_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Hours Worked : ");
        float Hours_Worked = scanner.nextFloat();
        System.out.println("Enter Rate Per Hour : ");
        float Rate_Per_Hour = scanner.nextFloat();

        scanner.close();

        float Salary = 0;

        if (Hours_Worked <= 40) {
            Salary = (Hours_Worked * Rate_Per_Hour);
        }
        else if (Hours_Worked > 40){
            Salary = (40 * Rate_Per_Hour) + ((Hours_Worked - 40) * (Rate_Per_Hour / 2));
        }

        System.out.println(Salary);
    }
}