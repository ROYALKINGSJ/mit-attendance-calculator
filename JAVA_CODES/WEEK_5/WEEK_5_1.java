import java.util.Scanner;

class STUDENT{
    SUBJECT Subjects_object_array[];

    void add_subjects(int sub_obj_number,int i){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Subject Name : ");
        String sub_name=sc.nextLine();

        System.out.println("Enter Subject Marks : ");
        int marks=sc.nextInt();

        SUBJECT subject_object_in_add_student=new SUBJECT();

        subject_object_in_add_student.assign(sub_name, marks);

        Subjects_object_array[i]=subject_object_in_add_student;

        subject_object_in_add_student.display();
    }

    class SUBJECT{
        String subject_name;
        int marks;

        void assign(String subject_name, int marks){
            this.subject_name=subject_name;
            this.marks=marks;
        }

        void display(){
            System.out.println("Subject Name : "+this.subject_name);
            System.out.println("Marks : "+marks);
        }
    }
}

public class WEEK_5_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Number Of Subjects : ");
        int sub_obj_number=sc.nextInt();

        STUDENT objector=new STUDENT();

        objector.Subjects_object_array=new STUDENT.SUBJECT[sub_obj_number];

        for (int i=0;i<sub_obj_number;i++){
            objector.add_subjects(sub_obj_number,i);
        }
    }
}