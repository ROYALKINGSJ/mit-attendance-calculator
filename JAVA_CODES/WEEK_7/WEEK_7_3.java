package OOPS_LAB.WEEK_7;

class Building{
    float sq_foot;
    float stories;

    Building(){
        this.sq_foot=1F;
        this.stories=1F;
    }

    Building(float sq_foot,float stories){
        this.sq_foot=sq_foot;
        this.stories=stories;
    }

    void display(){
        System.out.println("Square Foot : "+sq_foot);
        System.out.println("Stories : "+stories);
    }
}

class House extends Building{
    int bedroom;
    int baths;

    House(int bedroom,int baths){
        this.bedroom=bedroom;
        this.baths=baths;
    }

    House(float sq_foot,float stories,int bedroom,int baths){
        super(sq_foot,stories);
        this.bedroom=bedroom;
        this.baths=baths;
    }

    void display(){
        super.display();
        System.out.println("Number of Bedrooms : "+bedroom);
        System.out.println("Number of Bathrooms : "+baths);
    }
}

class School extends Building{
    String classroom;
    String grade;

    School(String classroom,String grade){
        this.classroom=classroom;
        this.grade=grade;
    }

    School(float sq_foot,float stories,String classroom,String grade){
        super(sq_foot,stories);
        this.classroom=classroom;
        this.grade=grade;
    }

    void display(){
        super.display();
        System.out.println("Classroom : "+classroom);
        System.out.println("Grade : "+grade);
    }
}

public class WEEK_7_3 {
    public static void main(String[] args) {
        System.out.println("--- House 1 (Default Building) ---");
        House obj_h_1=new House(2, 2);
        obj_h_1.display();

        System.out.println("\n--- House 2 (Custom Building) ---");
        House obj_h_2=new House(10, 2, 4, 4);
        obj_h_2.display();


        System.out.println("\n--- School 1 (Default Building) ---");
        School obj_s_1=new School("Senior High", "12th");
        obj_s_1.display();

        System.out.println("\n--- School 2 (Custom Building) ---");
        School obj_s_2=new School(10, 3, "Junior High", "6th");
        obj_s_2.display();
    }
}
