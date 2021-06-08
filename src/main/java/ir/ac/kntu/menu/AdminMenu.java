package ir.ac.kntu.menu;

import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;
import ir.ac.kntu.persons.Admin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class AdminMenu {
    enum Menu{ RESTAURANT_MENU,SUPERMARKET_MENU,FRUIT_SHOP_MENU,DELIVERY_MENU,ORDER_MENU,ADD_ADMIN}

    public AdminMenu(ArrayList<Restaurant> restaurants, ArrayList<SuperMarket> superMarkets,
                     ArrayList<FruitShop> fruitShops, ArrayList<Admin> admins) {
        menu(restaurants,superMarkets,fruitShops,admins);
    }

    private void menu(ArrayList<Restaurant> restaurants,ArrayList<SuperMarket> superMarkets,
                      ArrayList<FruitShop> fruitShops,ArrayList<Admin> admins){
        printMenu();
        if (checkTheFirstAdmin(admins)) {
            switch (selector(5)+1) {
                case 1:
                    new RestaurantMenuForAdmin(restaurants);
                    break;
                case 2:
                    //TODO SuperMarketAdmin
                    break;
                case 3:
                    //TODO FruitShopAdmin
                    break;
                case 4:
                    //TODO DeliveryAdmin
                    break;
                case 5:
                    //TODO orderAdmin
                    break;
                case 6:
                    addAdmin(admins);
                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }
    }

    private void addAdmin(ArrayList<Admin> admins) {
        System.out.println("Adding Admin    ");
        System.out.println("please Enter the name");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("please Enter the password");
        String password = ScannerWrapper.getInstance().nextLine();
        Admin admin = new Admin(name,password);
        admins.add(admin);
    }

    private boolean checkTheFirstAdmin(ArrayList<Admin> admins){
        Admin firstAdmin = admins.get(0);
        System.out.println("please Enter the name");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("please Enter the password");
        String password = ScannerWrapper.getInstance().nextLine();
        if (name.equals(firstAdmin.getName())) {
            if(password.equals(firstAdmin.getPassword())) {
                return true;
            }
        }
        System.out.println("Wrong Admin");
        return false;
    }

    private int selector(int bound){
        int chosen = new Random().nextInt(bound);
        try {
            chosen = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }

    private void printMenu(){
        Menu[] menus = Menu.values();
        for (int i = 0; i < menus.length; i++) {
            System.out.println(i+1 + " : " + menus[i]);
        }
    }
}
