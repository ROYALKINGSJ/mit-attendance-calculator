package OOPS_LAB.WEEK_4;

class Counter{
    long Counter_ID;
    static int Counter_Obj_Counter;

    Counter(long id){
        this.Counter_ID=id;
        Counter_Obj_Counter++;
    }

    void showCount(){
        System.out.println("Total Counter Objects created : "+ Counter_Obj_Counter);
    }
}


public class WEEK_4_4 {
    public static void main(String[] args) {
        System.out.println("Counter Objects created : "+Counter.Counter_Obj_Counter);
        Counter ob1=new Counter(101);
        ob1.showCount();
        Counter ob2=new Counter(102);
        ob2.showCount();
        Counter ob3=new Counter(103);
        ob3.showCount();
    }
}