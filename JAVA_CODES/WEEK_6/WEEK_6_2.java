package OOPS_LAB.WEEK_6;
import java.util.Scanner;

class EMPLOYEE{
    String Ename;

    void formatEmployeeName(){
        String temp="";
        String[] words_array=Ename.split(" +");

        for (int i=0;i<words_array.length;i++){
            for (int j=0;j<words_array[i].length();j++){
                if (j==0){
                    temp=temp+Character.toUpperCase(words_array[i].charAt(j));
                }
                else{
                    temp=temp+Character.toLowerCase(words_array[i].charAt(j));
                }
            }
            temp=temp+" ";
        }
        System.out.println("Formatted Employee Name : "+temp);
        this.Ename=temp;
    }

    void generateEmail(){
        String email="";
        String[] words_array=Ename.split(" +");

        for (int i=0;i<words_array.length;i++){
            if (i==0){
                email=email+((words_array[i].toLowerCase()).charAt(0));
            }
            else{
                email=email+words_array[i].toLowerCase();
            }
        }

        email=email+"@gmail.com";
        System.out.println("Generated Email : "+email);
    }
}

public class WEEK_6_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        EMPLOYEE objector=new EMPLOYEE();

        System.out.println("Enter Employee Name : ");
        objector.Ename=sc.nextLine();

        objector.formatEmployeeName();
        objector.generateEmail();
    
        sc.close();
    }
}