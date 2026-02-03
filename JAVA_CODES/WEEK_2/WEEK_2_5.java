import java.util.Scanner;

public class WEEK_2_5 {
    public static void main(){
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number : ");
        int num=sc.nextInt();
        sc.close();

        System.out.println(num+"! = "+Factorial_Calculator(num,1,1));
    }

    public static int Factorial_Calculator(int num,int fact,int i){
        fact=fact*i;

        if (i==num){
            return fact;
        }
        else{
            return Factorial_Calculator(num,fact,i+1);
        }
    }
}