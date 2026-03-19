package OOPS_LAB.WEEK_8;
import java.util.Scanner;

abstract class Figure {
    float x,y;

    Figure(float x,float y){
        this.x=x;
        this.y=y;
    }

    abstract void area();
}

class Rectangle extends Figure{
    Rectangle(float x,float y){
        super(x,y);
    }

    void area(){
        System.out.println("Area of Rectangle : "+(x*y));
    }
}

class Triangle extends Figure{
    Triangle(float x,float y){
        super(x,y);
    }

    void area(){
        System.out.println("Area of Triangle : "+((x*y)/2));
    }
}

class Square extends Figure{
    Square(float x){
        super(x,x);
    }

    void area(){
        System.out.println("Area of Square : "+(x*x));
    }
}

public class WEEK_8_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Length : ");
        float x=sc.nextFloat();
        System.out.println("Enter Breadth : ");
        float y=sc.nextFloat();

        Figure obj;
        obj = new Rectangle(x, y);
        obj.area();

        obj=new Triangle(x, y);
        obj.area();

        obj=new Square(x);
        obj.area();
    
        sc.close();
    }
}