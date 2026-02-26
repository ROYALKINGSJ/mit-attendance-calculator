package OOPS_LAB.WEEK_6;
import java.util.Scanner;

public class WEEK_6_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("*************   MAIN MENU   *************");
        System.out.println("1.Palindrome Checker");
        System.out.println("2.Alphabetical Arrange");
        System.out.println("3.Reverse String");
        System.out.println("4.Concatenate Original & Reverse String");
        System.out.println("************* ************* *************");
        int choice=sc.nextInt();

        System.out.println("Enter word : ");
        String word=sc.next();

        if (choice==1){
            Palindrome_Checker(sc, word);
        }
        else if (choice==2){
            Alphabetical_Arrange(sc, word);
        }
        else if (choice==3){
            Reverse_String(sc, word);
        }
        else if (choice==4){
            Concatenate_String(sc, word);
        }
        else{
            System.out.println("Invalid Choice Selection");
        }
    }

    static void Palindrome_Checker(Scanner sc,String word){
        String reverse_word="";
        for (int i=word.length()-1;i>=0;i--){
            reverse_word=reverse_word+word.charAt(i);
        }
        System.out.println("Reversed String : "+reverse_word);

        boolean result=word.equals(reverse_word);

        if (result==true){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }

    static void Alphabetical_Arrange(Scanner sc,String word){
        int[] word_ascii_values_array=new int[word.length()];

        for (int i=0;i<word.length();i++){
            word_ascii_values_array[i]=word.charAt(i);
        }

        for (int i=0;i<word_ascii_values_array.length-1;i++){
            for (int j=0;j<word_ascii_values_array.length-i-1;j++){
                if (word_ascii_values_array[j]>word_ascii_values_array[j+1]){
                    int temp=word_ascii_values_array[j];
                    word_ascii_values_array[j]=word_ascii_values_array[j+1];
                    word_ascii_values_array[j+1]=temp;
                }
            }
        }

        String alphabetically_arranged_word="";

        for (int i=0;i<word.length();i++){
            alphabetically_arranged_word=alphabetically_arranged_word+Character.toString(word_ascii_values_array[i]);
        }

        System.out.println(alphabetically_arranged_word);
    }

    static void Reverse_String(Scanner sc,String word){
        String reverse_word="";
        for (int i=word.length()-1;i>=0;i--){
            reverse_word=reverse_word+word.charAt(i);
        }
        System.out.println("Reversed String : "+reverse_word);
    }

    static void Concatenate_String(Scanner sc,String word){
        System.out.println("Starting Index (concatenation) : ");
        int starting_index=sc.nextInt();
        System.out.println("Ending Index (concatenation) : ");
        int ending_index=sc.nextInt();

        word=word.substring(starting_index, ending_index);

        String reverse_word="";
        for (int i=word.length()-1;i>=0;i--){
            reverse_word=reverse_word+word.charAt(i);
        }

        System.out.println("Concatenated Original String : "+word);
        System.out.println("Concatenated Reversed String : "+reverse_word);
    }
}
