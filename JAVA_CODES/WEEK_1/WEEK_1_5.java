import java.util.Scanner;

public class WEEK_1_5 {

    static String[] product_name_array=new String[100];
    static int[] product_price_array=new int[100];
    static int[] product_quantity_array=new int[100];
    static int i=0;
    static int[] cart_items_quantity_array=new int[100];

    public static void main() {
        System.out.println("******************************");
        System.out.println("1.Add Stock Information");
        System.out.println("2.Add Products (to Cart)");
        System.out.println("3.Remove Products (from Cart)");
        System.out.println("4.Finalize Order");
        System.out.println("******************************");

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Your Choice : ");
        int home_screen_choice=sc.nextInt();

        if (home_screen_choice==1){
            Add_Stock_Information_Function();
        }
        else if (home_screen_choice==2){
            Add_Products_Function();
        }
        else if (home_screen_choice==3){
            Remove_Products_Function();
        }
        else if (home_screen_choice==4){
            Finalize_Order_Function();
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Add_Stock_Information_Function(){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Enter Stock Product Name : ");
        String add_product_name=sc.nextLine();
        System.out.println("Enter Stock Product Price : ");
        int add_product_price=sc.nextInt();
        System.out.println("Enter Stock Product Quantity : ");
        int add_product_quantity=sc.nextInt();
        System.out.println("******************************");

        product_name_array[i]=add_product_name;
        product_price_array[i]=add_product_price;
        product_quantity_array[i]=add_product_quantity;
        i=i+1;

        System.out.println("******************************");
        System.out.println("Product Added Successfully");
        System.out.println("******************************");

        System.out.println("******************************");
        System.out.println("1.Add More");
        System.out.println("2.Go Back");
        System.out.println("******************************");

        int add_more_choice=sc.nextInt();

        if (add_more_choice==1){
            Add_Stock_Information_Function();
        }
        else if (add_more_choice==2){
            main();
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Add_Products_Function(){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Available Products List : ");
        for (int j = 0; j < i; j++) {
            System.out.println(product_name_array[j] + "\t" + product_price_array[j] + "\t" + product_quantity_array[j]);
        }
        System.out.println("******************************");

        System.out.println("Enter Product Name (to add to cart): ");
        String to_cart_product_name=sc.nextLine();
        System.out.println("Enter Product Quantity (to add to cart): ");
        int to_cart_product_qunatity=sc.nextInt();

        for (int j = 0; j < i; j++){
            if (to_cart_product_qunatity>0){
                if (product_name_array[j].equals(to_cart_product_name) ){
                    if (to_cart_product_qunatity>product_quantity_array[j]){
                        to_cart_product_qunatity=product_quantity_array[j];
                        System.out.println("Quantity Exceeded");
                        System.out.println("Quantity Updated to Max in Stock");
                        cart_items_quantity_array[j]=cart_items_quantity_array[j]+to_cart_product_qunatity;
                        break;
                    }
                    else if (to_cart_product_qunatity<=product_quantity_array[j]){
                        cart_items_quantity_array[j]=cart_items_quantity_array[j]+to_cart_product_qunatity;
                        break;
                    }       
                }
                else{
                    System.out.println("Product Not Found");
                }
            }
            else{
                System.out.println("Increase Quantity");
                break;
            }
        }

        System.out.println("******************************");
        System.out.println("1.Add More");
        System.out.println("2.Go Back");
        System.out.println("******************************");

        int add_more_choice=sc.nextInt();

        if (add_more_choice==1){
            Add_Products_Function();
        }
        else if (add_more_choice==2){
            main();
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Remove_Products_Function(){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Cart Products List : ");
        for (int j = 0; j < i; j++) {
            if (cart_items_quantity_array[j]>0){
                System.out.println(product_name_array[j] + "\t" + product_price_array[j] + "\t" + cart_items_quantity_array[j]);
            }
        }
        System.out.println("******************************");

        System.out.println("Enter Product Name (to remove from cart): ");
        String remove_cart_product_name=sc.nextLine();
        System.out.println("Enter Product Quantity (to remove from cart): ");
        int remove_cart_product_qunatity=sc.nextInt();

        for (int j = 0; j < i; j++){
            if (remove_cart_product_qunatity>0){
                if (product_name_array[j].equals(remove_cart_product_name) ){
                    if (remove_cart_product_qunatity>cart_items_quantity_array[j]){
                        remove_cart_product_qunatity=cart_items_quantity_array[j];
                    }
                    cart_items_quantity_array[j]=cart_items_quantity_array[j]-remove_cart_product_qunatity;
                    if (remove_cart_product_qunatity==cart_items_quantity_array[j]){
                        System.out.println("Product Removed Successfully");
                    }
                    else if (remove_cart_product_qunatity<cart_items_quantity_array[j]){
                        System.out.println("Product Quantity Removed Successfully");
                    }
                    break;
                }
                else{
                    System.out.println("Product Not Found");
                }
            }
        }
        System.out.println("******************************");
        System.out.println("1.Remove More");
        System.out.println("2.Go Back");
        System.out.println("******************************");

        int remove_more_choice=sc.nextInt();
        if (remove_more_choice==1){
            Remove_Products_Function();
        }
        else if (remove_more_choice==2){
            main();
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Finalize_Order_Function(){

        int total_price=0;

        System.out.println("******************************");
        System.out.println("Your Cart Products List : ");
        for (int j = 0; j < i; j++){
            if (cart_items_quantity_array[j]>0){
                System.out.println(product_name_array[j] + "\t" +product_price_array[j] + "\t" + cart_items_quantity_array[j]);
                total_price=total_price+(product_price_array[j]*cart_items_quantity_array[j]);
            }
        }

        System.out.println("******************************");
        System.out.println("Total Price : " + total_price);
        System.out.println("******************************");
    }
}