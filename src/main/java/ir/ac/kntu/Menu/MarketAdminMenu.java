package ir.ac.kntu.Menu;

import ir.ac.kntu.Delivery.Delivery;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Market.Restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class MarketAdminMenu {
    enum Option{ RESTAURANT_ADMIN_MENU,SUPERMARKET_ADMIN_MENU,FRUIT_SHOP_ADMIN_MENU}

    public MarketAdminMenu(ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries) {
        marketAdminMenu(restaurants,deliveries);
    }
    public void marketAdminMenu(ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries){
        System.out.println("pleas Enter the part you want to Enter");
        Option[] option = MarketAdminMenu.Option.values();
        for (int i = 0; i < option.length; i++) {
            System.out.println(option[i]);
        }
        int choice = 1 + new Random().nextInt(5);
        try {
            choice = ScannerWrapper.getInstance().nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("The choice is : " + choice);
        }
        ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case 1:
                new RestaurantAdminMenu(restaurants,deliveries);
                break;
            case 2:
                //TODO
                // SuperMarketAdminMenu
            case 3:
                //TODO
                // FruitShopAdminMenu
                break;
            default:
                break;
        }
    }
}
