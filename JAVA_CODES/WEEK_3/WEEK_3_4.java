class Die{
    int SideUp;

    Die(int SideUp){
        this.SideUp=SideUp;
    }
    
    public static void getSideUp(Die objector){
        System.out.println(objector.SideUp);
    }

    public static void roll(Die objector){
        objector.SideUp=(int)((Math.random())*(6+1));
        if (objector.SideUp==0){
            roll(objector);
        }
    }
}

public class WEEK_3_4 {
    public static void main(String[] args) {
        Die[] objector=new Die[2];

        for (int i = 0; i < 2; i++) {
            objector[i]=new Die(0);
            Die.roll(objector[i]);
            Die.getSideUp(objector[i]);
        }
    }
}