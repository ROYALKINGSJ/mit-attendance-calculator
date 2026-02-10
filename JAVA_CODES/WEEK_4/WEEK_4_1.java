package OOPS_LAB.WEEK_4;

class STUDENT{
    String sname;
    int age;
    int cls;

    STUDENT(){
        this.sname="Sanskar Jaiswal";
        this.age=19;
        this.cls=12;
    }
    STUDENT(String sname, int age, int cls){
        this.sname=sname;
        this.age=age;
        this.cls=cls;
    }

    void display(){
        System.out.println("Name : "+this.sname);
        System.out.println("Age : "+this.age);
        System.out.println("Class : "+this.cls);
    }
}

public class WEEK_4_1 {
    public static void main(String[] args) {
        STUDENT ob1=new STUDENT();
        STUDENT ob2=new STUDENT("Annantjeet Singh",19,12);

        ob1.display();
        ob2.display();
    }
}