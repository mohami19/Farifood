package ir.ac.kntu.menu;

import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;
import ir.ac.kntu.menu.sorting.FruitShopSorting;
import ir.ac.kntu.menu.sorting.RestaurantSorting;
import ir.ac.kntu.menu.sorting.SuperMarketSorting;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Features {
    enum Menu {RESTAURANT_FEATURES,FRUIT_SHOPS_FEATURES,SUPERMARKET_FEATURES}
    public Features(ArrayList<Restaurant> restaurants, ArrayList<SuperMarket> superMarkets,
                    ArrayList<FruitShop> fruitShops) {
        menu(restaurants,superMarkets,fruitShops);
    }

    private void menu(ArrayList<Restaurant> restaurants, ArrayList<SuperMarket> superMarkets,
                      ArrayList<FruitShop> fruitShops){
        printMenu();
        int choice = selector(4,1);
        if (choice == 1) {
            new RestaurantSorting(restaurants);
        } else if (choice == 2) {
            new FruitShopSorting(fruitShops);
        } else if (choice == 3) {
            new SuperMarketSorting(superMarkets);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i+1 + " : " + menu[i]);
        }
    }

    private int selector(int bound,int start){
        int chosen = start + new Random().nextInt(bound);
        try {
            chosen = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }

}