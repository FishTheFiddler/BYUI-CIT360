package WesCollectionTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create_Your_Breakfast {

    public static void main(String[] args) {

        System.out.println("\n*----Welcome to the Custom Breakfast Ordering Program----*");
        numberOfItems();
    }

    public static void numberOfItems() {
        System.out.println("\nTo begin, how many items would you like to order? (max 3)");
        Scanner sizeInput = new Scanner(System.in);
        int size = sizeInput.nextInt();
        if (size >= 1 && size <= 3){
            order(size);
        }
        if (size < 1 || size > 3 ){
            System.out.println("I'm sorry that is outside our ordering range.");
            numberOfItems();
        }
    }
    public static void order(int x) {
        List<String> menu = new ArrayList();
        menu.add("BACON");
        menu.add("EGGS");
        menu.add("TOAST");
        menu.add("WAFFLES");
        menu.add("HASH BROWNS");
        menu.add("PANCAKES");

        List customerOrder = new ArrayList();

        System.out.println("\nVery well, I shall have the chef prepare " + x + " item(s) for you.");
        System.out.println("Please choose " + x + " item(s) from the following menu.");
        System.out.println(menu);
        for (int i = 0; i < x; i++)
        {
            System.out.println("Item " + (i + 1) + ": ");
            Scanner item = new Scanner(System.in);
            String str1 = item.nextLine();
            boolean ans = menu.contains(str1.toUpperCase());
                if (ans){
                    System.out.println("Excellent, we have added " + str1.toLowerCase() + " to your order.");
                    customerOrder.add(str1);
                }
                if (!ans){
                    System.out.println("We are sorry, that item is not recognized on the menu and your order has been cancelled.");
                    order(x);
                    customerOrder.clear();
                }

        }
        System.out.println("Thank you for your order, the following will be served to you shortly.");
        System.out.println(customerOrder);


    }
}
