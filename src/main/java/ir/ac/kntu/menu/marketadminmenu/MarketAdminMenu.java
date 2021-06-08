package ir.ac.kntu.menu.marketadminmenu;

import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class MarketAdminMenu {
    enum Option{ RESTAURANT_ADMIN_MENU,SUPERMARKET_ADMIN_MENU,FRUIT_SHOP_ADMIN_MENU}

    public MarketAdminMenu(ArrayList<Restaurant> restaurants,ArrayList<SuperMarket> superMarkets,
                           ArrayList<FruitShop> fruitShops) {
        marketAdminMenu(restaurants,superMarkets,fruitShops);
    }
    public void marketAdminMenu(ArrayList<Restaurant> restaurants,ArrayList<SuperMarket> superMarkets,
                                ArrayList<FruitShop> fruitShops){
        System.out.println("pleas Enter the part you want to Enter");
        Option[] option = MarketAdminMenu.Option.values();
        for (int i = 0; i < option.length; i++) {
            System.out.println((i+1)+ " : "+ option[i]);
        }
        int choice = 1 + new Random().nextInt(5);
        try {
            choice = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        switch (choice) {
            case 1:
                new RestaurantAdminMenu(restaurants);
                break;
            case 2:
                new SuperMarketAdminMenu(superMarkets);
            case 3:
                new FruitShopAdminMenu(fruitShops);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }
}
