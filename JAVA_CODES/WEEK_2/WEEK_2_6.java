import java.util.Scanner;

public class WEEK_2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Electricity Units Consumption[7 Days] : ");
        float Electricity_Units_Consumption = sc.nextFloat();

        sc.close();

        switch ((int)((Electricity_Units_Consumption-1)/(100))) {
            case 0:
                System.out.println("Total Bill : "+Electricity_Units_Consumption*7);
                break;
            case 1:
                System.out.println("Total Bill : "+Electricity_Units_Consumption*8);
                break;
            default:
                System.out.println("Total Bill : "+Electricity_Units_Consumption*10);
                break;
        }
    }    
}
