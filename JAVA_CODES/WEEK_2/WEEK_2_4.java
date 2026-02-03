import java.util.Scanner;

public class WEEK_2_4 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Dimenation of Matrix : ");
        int n=sc.nextInt();

        int[][] arr=new int[n][n];

        int sum=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter Element [" + (i+1) + "] [" + (j+1) + "] : ");
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println("********************");

        for (int i=0;i<n;i++) {
            for (int j=n-1;j>=0;j--) {
                if ((i+j)==(n-1)){
                    System.out.print(arr[i][j] + " ");
                    sum=sum+arr[i][j];
                }
            }
        }
        
        System.out.println("SUM : "+sum);
        sc.close();
    }
}
