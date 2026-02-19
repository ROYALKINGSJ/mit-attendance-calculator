import java.util.Scanner;

public class WEEK_5_3 {
    Item item_obj=new Item();

    class Item{
        static String[] product_name_array=new String[100];
        static int[] product_price_array=new int[100];
        static int[] product_quantity_array=new int[100];
        static int i=0;
        static int[] cart_items_quantity_array=new int[100];
    }

    public static void main(String[] args) {
        main(new WEEK_5_3());
    }

    public static void main(WEEK_5_3 main_obj) {
        if (main_obj==null){
            main_obj=new WEEK_5_3();
        }

        System.out.println("******************************");
        System.out.println("1.Add Stock Information");
        System.out.println("2.Add Products (to Cart)");
        System.out.println("3.Remove Products (from Cart)");
        System.out.println("4.Show Products (from Cart)");
        System.out.println("5.Finalize Order");
        System.out.println("******************************");

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Your Choice : ");
        int home_screen_choice=sc.nextInt();
        
        if (home_screen_choice==1){
            Add_Stock_Information_Function(main_obj,main_obj.item_obj);
        }
        else if (home_screen_choice==2){
            Add_Products_Function(main_obj,main_obj.item_obj);
        }
        else if (home_screen_choice==3){
            Remove_Products_Function(main_obj,main_obj.item_obj);
        }
        else if (home_screen_choice==4){
            Show_Product_function(main_obj,main_obj.item_obj);
        }
        else if (home_screen_choice==5){
            Finalize_Order_Function(main_obj,main_obj.item_obj);
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Add_Stock_Information_Function(WEEK_5_3 main_obj,Item item_obj){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Enter Stock Product Name : ");
        String add_product_name=sc.nextLine();
        System.out.println("Enter Stock Product Price : ");
        int add_product_price=sc.nextInt();
        System.out.println("Enter Stock Product Quantity : ");
        int add_product_quantity=sc.nextInt();
        System.out.println("******************************");

        item_obj.product_name_array[item_obj.i]=add_product_name;
        item_obj.product_price_array[item_obj.i]=add_product_price;
        item_obj.product_quantity_array[item_obj.i]=add_product_quantity;
        item_obj.i=item_obj.i+1;
        // Item.i++;

        System.out.println("******************************");
        System.out.println("Product Added Successfully");
        System.out.println("******************************");

        System.out.println("******************************");
        System.out.println("1.Add More");
        System.out.println("2.Go Back");
        System.out.println("******************************");

        int add_more_choice=sc.nextInt();

        if (add_more_choice==1){
            Add_Stock_Information_Function(main_obj,item_obj);
        }
        else if (add_more_choice==2){
            main(main_obj);
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Add_Products_Function(WEEK_5_3 main_obj,Item item_obj){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Available Products List : ");
        for (int j = 0; j < item_obj.i; j++) {
            System.out.println(item_obj.product_name_array[j] + "\t" + item_obj.product_price_array[j] + "\t" + item_obj.product_quantity_array[j]);
        }
        System.out.println("******************************");

        System.out.println("Enter Product Name (to add to cart): ");
        String to_cart_product_name=sc.nextLine();
        System.out.println("Enter Product Quantity (to add to cart): ");
        int to_cart_product_qunatity=sc.nextInt();

        for (int j = 0; j < item_obj.i; j++){
            if (to_cart_product_qunatity>0){
                if (item_obj.product_name_array[j].equals(to_cart_product_name) ){
                    if (to_cart_product_qunatity>item_obj.product_quantity_array[j]){
                        to_cart_product_qunatity=item_obj.product_quantity_array[j];
                        System.out.println("Quantity Exceeded");
                        System.out.println("Quantity Updated to Max in Stock");
                        item_obj.cart_items_quantity_array[j]=item_obj.cart_items_quantity_array[j]+to_cart_product_qunatity;
                        break;
                    }
                    else if (to_cart_product_qunatity<=item_obj.product_quantity_array[j]){
                        item_obj.cart_items_quantity_array[j]=item_obj.cart_items_quantity_array[j]+to_cart_product_qunatity;
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
            Add_Products_Function(main_obj,item_obj);
        }
        else if (add_more_choice==2){
            main(main_obj);
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Remove_Products_Function(WEEK_5_3 main_obj,Item item_obj){

        Scanner sc=new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Cart Products List : ");
        for (int j = 0; j < item_obj.i; j++) {
            if (item_obj.cart_items_quantity_array[j]>0){
                System.out.println(item_obj.product_name_array[j] + "\t" + item_obj.product_price_array[j] + "\t" + item_obj.cart_items_quantity_array[j]);
            }
        }
        System.out.println("******************************");

        System.out.println("Enter Product Name (to remove from cart): ");
        String remove_cart_product_name=sc.nextLine();
        System.out.println("Enter Product Quantity (to remove from cart): ");
        int remove_cart_product_qunatity=sc.nextInt();

        for (int j = 0; j < item_obj.i; j++){
            if (remove_cart_product_qunatity>0){
                if (item_obj.product_name_array[j].equals(remove_cart_product_name) ){
                    if (remove_cart_product_qunatity>item_obj.cart_items_quantity_array[j]){
                        remove_cart_product_qunatity=item_obj.cart_items_quantity_array[j];
                    }
                    item_obj.cart_items_quantity_array[j]=item_obj.cart_items_quantity_array[j]-remove_cart_product_qunatity;
                    if (remove_cart_product_qunatity==item_obj.cart_items_quantity_array[j]){
                        System.out.println("Product Removed Successfully");
                    }
                    else if (remove_cart_product_qunatity<item_obj.cart_items_quantity_array[j]){
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
            Remove_Products_Function(main_obj,item_obj);
        }
        else if (remove_more_choice==2){
            main(main_obj);
        }
        else{
            System.out.println("Invalid Choice");
        }
    }

    public static void Show_Product_function(WEEK_5_3 main_obj,Item item_obj){

        System.out.println("******************************");
        System.out.println("Cart Products List : ");
        for (int j = 0; j < item_obj.i; j++) {
            if (item_obj.cart_items_quantity_array[j]>0){
                System.out.println(item_obj.product_name_array[j] + "\t" + item_obj.product_price_array[j] + "\t" + item_obj.cart_items_quantity_array[j]);
            }
        }
        System.out.println("******************************");

        main(main_obj);
    }

    public static void Finalize_Order_Function(WEEK_5_3 main_obj,Item item_obj){

        int total_price=0;

        System.out.println("******************************");
        System.out.println("Your Cart Products List : ");
        for (int j = 0; j < item_obj.i; j++){
            if (item_obj.cart_items_quantity_array[j]>0){
                System.out.println(item_obj.product_name_array[j] + "\t" +item_obj.product_price_array[j] + "\t" + item_obj.cart_items_quantity_array[j]);
                total_price=total_price+(item_obj.product_price_array[j]*item_obj.cart_items_quantity_array[j]);
            }
        }

        System.out.println("******************************");
        System.out.println("Total Price : " + total_price);
        System.out.println("******************************");
    }
}