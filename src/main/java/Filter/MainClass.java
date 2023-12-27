package Filter;

import application.Service;

import java.util.Scanner;

public class MainClass {
    private static ServiceClass service = new ServiceClass();
    static Scanner sc =new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("SELECT OPTION");
        System.out.println("1. BY PRICE");
        System.out.println("2. BY CATEGORY");
        System.out.println("3.Exit");
        int ch=sc.nextInt();

        switch (ch){
            case 1:
                filterProductByPrice();
                break;
            case 2:
                filterProductByCategory();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("INVALID OPTION");

        }
        main(args);

    }
    public static void filterProductByPrice(){
        System.out.println("ENTER PRODUCT price");
        double productPrice = sc.nextDouble() ;

        Product p = service.filterProductByPrice(productPrice);
        System.out.println("Id \t\t Name \t\t Price \t\t Type ");
        System.out.println(p.getProductId() +" \t "+ p.getProductName() +" \t "+ p.getProductPrice() +" \t "+p.getProductType());

    }
    public static void filterProductByCategory(){
        System.out.println("ENTER PRODUCT CATEGORY");
        String productType = sc.next() ;

        Product p = service.filterProductByCategory(productType);
        System.out.println("Id \t\t Name \t\t Price \t\t Type ");
        System.out.println(p.getProductId() +" \t "+ p.getProductName() +" \t "+ p.getProductPrice() +" \t "+p.getProductType());

    }

}
