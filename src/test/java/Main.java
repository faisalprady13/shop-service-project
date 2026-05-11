import order.OrderMapRepo;
import product.Product;
import product.ProductRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static void main() {
        String position = "lobby";
        Scanner scanner = new Scanner(System.in);
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));

        ProductRepo pr = new ProductRepo();
        OrderMapRepo or = new OrderMapRepo();

        pr.add(product1);
        pr.add(product1);
        pr.add(product1);
        pr.add(product2);
        pr.add(product2);

        ShopService shopService = new ShopService(pr, or);
        System.out.println(ANSI_GREEN + "Welcome to guild shop, we have:" + ANSI_RESET);
        shopService.listProduct();
        System.out.printf(ANSI_GREEN + "\nWhat would you like to do?\n" + ANSI_RESET);
        System.out.println("1. Place order\n2. Change order\n3. Exit\n");
        while (true) {
            String input = scanner.nextLine();


            if (input.equalsIgnoreCase("1")) {
                System.out.println(ANSI_GREEN + "\nPlease list the items you wish to order" + ANSI_RESET);

//                String[] ids = input.split(",");
//
//                UUID[] uuidArray = new UUID[ids.length];
//
//                for (int i = 0; i < ids.length; i++) {
//                    uuidArray[i] = UUID.fromString(ids[i].trim());
//                }
            }

            if (input.equalsIgnoreCase("3")) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.println("You entered: " + input);
        }

        scanner.close();
    }

}
