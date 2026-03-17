package OOPS_LAB.WEEK_6;
import java.util.Scanner;

class STUDENT{
    String[] name;
    static int i;

    void extractInitials(){
        String temp="";
        String[] words_array=name[i].split(" +");

        for (String word:words_array){
            temp=temp+(word.toUpperCase()).charAt(0);
        }

        System.out.println("Initials : "+temp);
    }

    void removeWhitespace(){
        String temp="";
        String[] words_array=name[i].split(" +");

        for (String word:words_array){
            temp=temp+word;
        }

        System.out.println("Removed Whitespace : "+temp);
    }

    void subString(String sub){
        for (int j=0;j<=i;j++){
            if (name[j].contains(sub)){
                System.out.println("'"+sub+"'"+" found in "+name[j]);
            }
        }
    }

    void sort(){
        for (int j=0;j<i;j++){
            for (int k=0;k<=i-j-1;k++){
                if (name[k].compareToIgnoreCase(name[k+1])>0){
                    String temp=name[k];
                    name[k]=name[k+1];
                    name[k+1]=temp;
                }
            }
        }

        System.out.println("Sorted List : ");

        for (int j=0;j<=i;j++){
            System.out.print("    ");
            System.out.println(name[j]);
        }
    }
}

public class WEEK_6_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Number of Students : ");
        int n=sc.nextInt();
        sc.nextLine();

        STUDENT obj=new STUDENT();
        obj.name=new String[n];

        for (int i=0;i<n;i++){
            System.out.println("***** ***** *****");
            System.out.println("Student Name : ");
            String name=sc.nextLine();

            obj.name[i]=name;
            STUDENT.i=i;

            obj.extractInitials();
            obj.removeWhitespace();

            System.out.println("***** ***** *****");
        }

        System.out.println("Enter Substring to Search : ");
        String sub=sc.nextLine();

        obj.subString(sub);

        System.out.println("***** ***** *****");

        obj.sort();

        sc.close();
    }
}