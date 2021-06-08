package ir.ac.kntu.menu.marketadminmenu;

import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.persons.FruitShopAdmin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class FruitShopAdminMenu {
    enum Menu {MODIFY_FRUIT_SHOP,SEE_THE_COMMENTS}

    public FruitShopAdminMenu(ArrayList<FruitShop> fruitShops) {
        menu(fruitShops);
    }

    private void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i+1 + " : " + menu[i]);
        }
    }

    private void menu(ArrayList<FruitShop> fruitShops){
        printMenu();
        switch (selector(2,1)){
            case 1:
                modifyFruitShop(fruitShops);
                break;
            case 2:
                seeTheCommentsOfOneFruitShop(fruitShops);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private void seeTheCommentsOfOneFruitShop(ArrayList<FruitShop> fruitShops) {
        printFruitShop(fruitShops);
        int choice = selector(fruitShops.size());
        System.out.println(fruitShops.get(choice).getComments());
    }

    private void modifyFruitShop(ArrayList<FruitShop> fruitShops){
        printFruitShop(fruitShops);
        System.out.println("Please Enter the Restaurant That You Want To Modify");
        int choice = selector(fruitShops.size(),1);
        if (checkAdmin(fruitShops.get(choice-1))) {
            System.out.println("Do You Want To Modify If so Enter Yes" +
                    " and If you don't want to add press Enter");
            String input = ScannerWrapper.getInstance().nextLine().trim();
            while(input.matches("[Yy]es|[Yy]")){
                System.out.println("What do You want to modify");
                printFruitShopModifyMenu();
                switch (selector(6,1)) {
                    case 1:
                        System.out.println("Enter the Name");
                        fruitShops.get(choice-1).setName(ScannerWrapper.getInstance().nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the address");
                        fruitShops.get(choice-1).setAddress(new Address().addAddress());
                        break;
                    case 3:
                        System.out.println("please enter the starting time");
                        fruitShops.get(choice-1).setBeggingTime(new Time().addTime());
                        break;
                    case 4:
                        System.out.println("please enter the ending time");
                        fruitShops.get(choice-1).setEndingTime(new Time().addTime());
                        break;
                    case 5:
                        System.out.println("Enter the star");
                        fruitShops.get(choice-1).setStar(scoreGetter());
                        break;
                    case 6:
                        System.out.println("please Enter the new food (the saved food will be removed)");
                        fruitShops.get(choice-1).setFruits(new FruitShop().addFruits());
                        break;
                    default:
                        System.out.println("nothing has been changed");
                        break;
                }
                System.out.println("The modified restaurant : " + fruitShops.get(choice - 1).toString());
                System.out.println("Do You Want To Modify more so Enter Yes" +
                        " and If you don't want to modify press Enter");
                input = ScannerWrapper.getInstance().nextLine().trim();
            }
        }
    }

    private boolean checkAdmin(FruitShop fruitShop) {
        FruitShopAdmin fruitShopAdmin = addFruitShopAdmin(fruitShop);
        if (!fruitShop.getFruitShopAdmin().checkRestaurantAdmin(fruitShopAdmin)) {
            System.out.println("Wrong Admin");
            return false;
        }
        return true;
    }

    private FruitShopAdmin addFruitShopAdmin(FruitShop fruitShop) {
        System.out.println("please Enter the name of the owner for log in");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("please Enter the password of the owner for log in");
        String password = ScannerWrapper.getInstance().nextLine();
        return new FruitShopAdmin(name,password,fruitShop);
    }

    private void printFruitShop(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            System.out.println(i+1 + " : " + fruitShops.get(i));
        }
    }

    private void printFruitShopModifyMenu(){
        System.out.println("1 : name;");
        System.out.println("2 : address");
        System.out.println("3 : beggingTime");
        System.out.println("4 : endingTime");
        System.out.println("5 : star");
        System.out.println("6 : add Fruits");
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

    private double scoreGetter(){
        double score = new Random().nextInt(5) + 1;
        try {
            score = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return score;
    }
}
