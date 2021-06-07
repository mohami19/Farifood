package ir.ac.kntu.menu;

import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.SuperMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperMarketAdminMenu {
    enum Menu {ADD_SUPERMARKET,MODIFY_SUPERMARKET,SEE_THE_COMMENTS}

    public SuperMarketAdminMenu(ArrayList<SuperMarket> superMarkets) {
        menu(superMarkets);
    }

    private void menu(ArrayList<SuperMarket> superMarkets) {
        printMenu();
        System.out.println("please chose the thing you want to do");
        switch (selector(3)+1){
            default:
                break;
        }
    }

    private void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
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
}
