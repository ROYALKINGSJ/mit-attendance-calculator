package OOPS_LAB.WEEK_4;

class EMPLOYEE{
    String ename;
    int eid;

    EMPLOYEE(){
        this.ename="Sanskar Jaiswal";
        this.eid=101;
    }
    EMPLOYEE(String ename, int eid){
        this.ename=ename;
        this.eid=eid;
    }
    void display(){
        System.out.println("Name : "+this.ename);
        System.out.println("ID : "+this.eid);
    }
}

public class WEEK_4_2 {
    public static void main(String[] args) {
        EMPLOYEE ob1=new EMPLOYEE();
        EMPLOYEE ob2=new EMPLOYEE("Annantjeet Singh",102);

        ob1.display();
        ob2.display();
    }
}