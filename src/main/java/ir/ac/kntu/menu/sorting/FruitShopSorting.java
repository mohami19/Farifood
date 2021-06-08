package ir.ac.kntu.menu.sorting;

import ir.ac.kntu.Stuff.Fruit;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.FruitShop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class FruitShopSorting {
    public FruitShopSorting(ArrayList<FruitShop> fruitShops) {
        fruitShopSorting(fruitShops);
    }

    private void fruitShopSorting(ArrayList<FruitShop> fruitShops){
        System.out.println("Please chose the FruitShop 's sorting");
        printSortOfMarket();
        sortFruitShop(selector(4,1),fruitShops);
        System.out.println("Please chose the Fruits 's sorting");
        printSortOfStuff();
        sortFruits(selector(fruitShops.size(),0),fruitShops);
    }

    private void sortFruitShop(int choice,ArrayList<FruitShop> fruitShops) {
        if (choice == 1) {
            sortFruitShopByStarAscending(fruitShops);
        } else if (choice == 2) {
            sortFruitShopByStarDescending(fruitShops);
        } else if (choice == 3) {
            sortFruitShopByIdeaAscending(fruitShops);
        } else if (choice == 4) {
            sortFruitShopByIdeaDescending(fruitShops);
        } else {
            System.out.println("Wrong Input");
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

    private void fruitShopSwap(int first,int second,ArrayList<FruitShop> fruitShops) {
        FruitShop temp = fruitShops.get(first);
        fruitShops.set(first,fruitShops.get(second));
        fruitShops.set(second,temp);
    }

    private void sortFruitShopByIdeaDescending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            for (int j = 0; j < fruitShops.size()- i - 1; j++) {
                if (fruitShops.get(j+1).getComments().size() > fruitShops.get(j).getComments().size()) {
                    fruitShopSwap(j,j+1,fruitShops);
                }
            }
        }
    }

    private void sortFruitShopByIdeaAscending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            for (int j = 0; j < fruitShops.size()- i - 1; j++) {
                if (fruitShops.get(j+1).getComments().size() < fruitShops.get(j).getComments().size()) {
                    fruitShopSwap(j,j+1,fruitShops);
                }
            }
        }
    }

    private void sortFruitShopByStarDescending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            for (int j = 0; j < fruitShops.size()- i - 1; j++) {
                if (fruitShops.get(j+1).getStar() > fruitShops.get(j).getStar()) {
                    fruitShopSwap(j,j+1,fruitShops);
                }
            }
        }
    }

    private void sortFruitShopByStarAscending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            for (int j = 0; j < fruitShops.size()- i - 1; j++) {
                if (fruitShops.get(j+1).getStar() < fruitShops.get(j).getStar()) {
                    fruitShopSwap(j,j+1,fruitShops);
                }
            }
        }
    }

    private void sortFruits(int choice,ArrayList<FruitShop> fruitShops) {
        if (choice == 1) {
            sortFruitsByStarAscending(fruitShops);
        } else if (choice == 2) {
            sortFruitsByStarDescending(fruitShops);
        } else if (choice == 3) {
            sortFruitsByPriceAscending(fruitShops);
        } else if (choice == 4) {
            sortFruitsByPriceDescending(fruitShops);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void fruitSwap(int fruitShop,int first,int second,ArrayList<FruitShop> fruitShops){
        FruitShop fruitShop1 = fruitShops.get(fruitShop);
        Fruit temp = fruitShop1.getFruits().get(first);
        fruitShop1.getFruits().set(first, fruitShops.get(fruitShop).getFruits().get(second));
        fruitShop1.getFruits().set(second, temp);
    }

    private void sortFruitsByPriceAscending(ArrayList<FruitShop> fruitShops){
        for (int i = 0; i < fruitShops.size(); i++) {
            FruitShop fruitShop = fruitShops.get(i);
            for (int j = 0; j < fruitShop.getFruits().size(); j++) {
                for (int k = 0; k < fruitShop.getFruits().size() - j - 1; k++) {
                    if (fruitShop.getFruits().get(k+1).getPrice() < fruitShop.getFruits().get(k).getPrice()) {
                        fruitSwap(i,k,k+1,fruitShops);
                    }
                }
            }
        }
    }

    private void sortFruitsByPriceDescending(ArrayList<FruitShop> fruitShops){
        for (int i = 0; i < fruitShops.size(); i++) {
            FruitShop fruitShop = fruitShops.get(i);
            for (int j = 0; j < fruitShop.getFruits().size(); j++) {
                for (int k = 0; k < fruitShop.getFruits().size() - j - 1; k++) {
                    if (fruitShop.getFruits().get(k+1).getPrice() > fruitShop.getFruits().get(k).getPrice()) {
                        fruitSwap(i,k,k+1,fruitShops);
                    }
                }
            }
        }
    }

    private void sortFruitsByStarAscending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            FruitShop fruitShop = fruitShops.get(i);
            for (int j = 0; j < fruitShop.getFruits().size(); j++) {
                for (int k = 0; k < fruitShop.getFruits().size() - j - 1; k++) {
                    if (fruitShop.getFruits().get(k).getStar() > fruitShop.getFruits().get(k + 1).getStar()) {
                        fruitSwap(i,k,k+1,fruitShops);
                    }
                }
            }
        }
    }

    private void sortFruitsByStarDescending(ArrayList<FruitShop> fruitShops) {
        for (int i = 0; i < fruitShops.size(); i++) {
            FruitShop fruitShop = fruitShops.get(i);
            for (int j = 0; j < fruitShop.getFruits().size(); j++) {
                for (int k = 0; k < fruitShop.getFruits().size() - j - 1; k++) {
                    if (fruitShop.getFruits().get(k).getStar() < fruitShop.getFruits().get(k + 1).getStar()) {
                        fruitSwap(i,k,k+1,fruitShops);
                    }
                }
            }
        }
    }

    private void printSortOfStuff(){
        System.out.println("1 : Sort by star Ascending");
        System.out.println("2 : Sort by star Descending");
        System.out.println("3 : Sort by Price Ascending");
        System.out.println("4 : Sort by Price Descending");
    }

    private void printSortOfMarket(){
        System.out.println("1 : by star Ascending");
        System.out.println("2 : by star Descending");
        System.out.println("3 : by the numbers of ideas up down");
        System.out.println("4 : by the numbers of ideas down up");
    }
}
