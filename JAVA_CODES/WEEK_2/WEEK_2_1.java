import java.util.Scanner;

public class WEEK_2_1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        float distance_travelled=0;
        System.out.println("Total Cost : ");
        float total_cost=sc.nextFloat();

        if (total_cost<=50){
            distance_travelled=total_cost/10;
        }
        else if (total_cost>50 && total_cost<=170){
            distance_travelled=5+((total_cost-50)/8);
        }
        else if (total_cost>170 && total_cost<=295){
            distance_travelled=20+((total_cost-170)/5);
        }

        System.out.println("Distance Travelled : " + distance_travelled);
        sc.close();
    }
}