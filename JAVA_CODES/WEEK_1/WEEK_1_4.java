import java.util.Scanner;

public class WEEK_1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Total Elements : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Element " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Starting Position : ");
        int starting_position=sc.nextInt();
        System.out.println("Ending Position : ");
        int ending_position=sc.nextInt();
        System.out.println("Number of Steps : ");
        int steps=sc.nextInt();

        
        System.out.println("1.Right Shift");
        System.out.println("2.Left Shift");
        int choice = sc.nextInt();
        sc.close();
        
        if (choice==1){
            for (int i = 0; i < steps; i++) {
                for (int j = ending_position; j >= starting_position; j--) {
                    int temp = arr[j+i];
                    arr[j+i] = arr[j+i-1];
                    arr[j+i-1] = temp;
                }
            }
        }
        else if (choice==2){
            for (int i = 0; i < steps; i++) {
                for (int j = starting_position; j <= ending_position; j++) {
                    int temp = arr[j-i-1];
                    arr[j-i-1] = arr[j-i-2];
                    arr[j-i-2] = temp;
                }
            }
        }
        else{
            System.out.println("Invalid Choice");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
