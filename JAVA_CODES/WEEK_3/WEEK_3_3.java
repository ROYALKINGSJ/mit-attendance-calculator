import java.util.Scanner;

class Mixer{
    int arr[];

    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Array Size : ");
        int n=sc.nextInt();
        arr=new int[n];

        int i=0;

        while (i<n){
            int duplicates_found=0;

            System.out.println("Enter Element "+(i+1)+" : ");
            int number_to_add=sc.nextInt();

            for (int j = 0; j < i; j++) {
                if (number_to_add==arr[j]){
                    duplicates_found+=1;
                }
            }

            if (duplicates_found==0){
                if (i==0){
                        arr[i]=number_to_add;
                        i++;
                    }
                else if (i==1){
                    if (number_to_add>arr[0]){
                        arr[1]=number_to_add;
                        i++;
                    }
                    else{
                        int temp=arr[0];
                        arr[0]=number_to_add;
                        arr[1]=temp;
                        i++;
                    }
                }
                else{
                    if (number_to_add>arr[i-1]){
                        arr[i]=number_to_add;
                        i++;
                    }
                    else if (number_to_add<arr[0]){
                        for (int k=i;k>=1;k--){
                            arr[k]=arr[k-1];
                        }
                        arr[0]=number_to_add;
                        i++;
                    }
                    else{
                        int k;
                        for (k=0;k<(i-1);k++){
                            if (number_to_add>arr[k] && number_to_add<arr[k+1]){
                                break;
                            }
                        }
                        for (int l=i;l>(k+1);l--){
                            arr[l]=arr[l-1];
                        }
                        arr[k+1]=number_to_add;
                        i++;
                    }
                }
            }
            else{
                System.out.println("Duplicate Found");
            }
        }

        return;
    }

    Mixer mix(Mixer A){
        Mixer mixed_array_obj=new Mixer();
        int n1=this.arr.length;
        int n2=A.arr.length;
        mixed_array_obj.arr=new int[n1+n2];
        int index=0,i=0,j=0;

        while (i<n1 && j<n2) {
            if (this.arr[i]<A.arr[j]){
                mixed_array_obj.arr[index]=this.arr[i];
                index++;
                i++;
            }
            else if (this.arr[i]>A.arr[j]){
                mixed_array_obj.arr[index]=A.arr[j];
                index++;
                j++;
            }
            else if (this.arr[i]==A.arr[j]){
                mixed_array_obj.arr[index]=this.arr[i];
                index++;
                i++;
                j++;
            }
        }

        if (j==n2 && i!=n1){
            for (int k=i;k<n1;k++){
                mixed_array_obj.arr[index]=this.arr[k];
                index++;
            }
        }
        if (i==n1 && j!=n2){
            for (int k=j;k<n2;k++){
                mixed_array_obj.arr[index]=A.arr[k];
                index++;
            }
        }

        Mixer final_returning_object=new Mixer();
        final_returning_object.arr=new int[index];
        for (int k=0;k<index;k++){
            final_returning_object.arr[k]=mixed_array_obj.arr[k];
        }

        return final_returning_object;
    }

    void display(){
        System.out.println("Array : ");
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }

}

public class WEEK_3_3{
    public static void main(String[] args) {
        Mixer[] objector=new Mixer[3];

        objector[0]=new Mixer();
        objector[1]=new Mixer();
        objector[2]=new Mixer();

        objector[0].accept();
        objector[1].accept();

        objector[2]=objector[0].mix(objector[1]);

        objector[2].display();
    }
}