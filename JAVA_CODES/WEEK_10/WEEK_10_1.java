package OOPS_LAB.WEEK_10;

import java.util.Scanner;

class STUDENT{
    private String name;
    private int age;

    void registerStudent(String name, int age){
        this.name=name;
        this.age=age;

        if (age>=18 && age<=60){
            System.out.println("Noice - Access Granted");
        }
        else{
            throw new IllegalArgumentException("Access denied - You must be in between 18 and 60 years old to register.");
        }
    }
}

public class WEEK_10_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("How many instances : ");
        int n=sc.nextInt();

        STUDENT[] obj=new STUDENT[n];

        for (int i=0;i<n;i++){
            obj[i]=new STUDENT();

            System.out.println("*** Student "+(i+1)+" ***");

            System.out.println("Enter name : ");
            String name=sc.next();

            System.out.println("Enter age : ");
            int age=sc.nextInt();

            try {
                obj[i].registerStudent(name, age);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
