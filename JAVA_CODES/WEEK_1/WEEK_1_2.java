import java.util.Scanner;

public class WEEK_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number 1 : ");
        int Num_1= scanner.nextInt();
        System.out.println("Enter Number 2 : ");
        int Num_2= scanner.nextInt();

        scanner.close();

        System.out.println(Bitwise_Adder(Num_1, Num_2));
    }
    
    public static int Bitwise_Adder(int a, int b) {
        while (b!=0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}