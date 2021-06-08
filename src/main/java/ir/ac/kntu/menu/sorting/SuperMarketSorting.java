package ir.ac.kntu.menu.sorting;

import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.SuperMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperMarketSorting {

    public SuperMarketSorting(ArrayList<SuperMarket> superMarkets) {
        superMarketSorting(superMarkets);
    }

    private int selector(int bound, int start){
        int chosen = start + new Random().nextInt(bound);
        try {
            chosen = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }

    private void superMarketSorting(ArrayList<SuperMarket> superMarkets){
        System.out.println("Please chose the SuperMarket 's sorting");
        printSortOfMarket();
        sortSuperMarket(selector(4,1),superMarkets);
        System.out.println("Please chose the SuperMarket 's sorting");
        printSortOfItem();
        sortItems(selector(superMarkets.size(),0),superMarkets);
    }

    private void sortSuperMarket(int choice, ArrayList<SuperMarket> superMarkets) {
        if (choice == 1) {
            sortSuperMarketByStarAscending(superMarkets);
        } else if (choice == 2) {
            sortSuperMarketByStarDescending(superMarkets);
        } else if (choice == 3) {
            sortSuperMarketByIdeaAscending(superMarkets);
        } else if (choice == 4) {
            sortSuperMarketByIdeaDescending(superMarkets);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void sortItems(int choice,ArrayList<SuperMarket> superMarkets) {
        if (choice == 1) {
            sortItemsByNumberAscending(superMarkets);
        } else if (choice == 2) {
            sortItemsByNumberDescending(superMarkets);
        } else if (choice == 3) {
            sortItemsByPriceAscending(superMarkets);
        } else if (choice == 4) {
            sortItemsByPriceDescending(superMarkets);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void sortItemsByPriceDescending(ArrayList<SuperMarket> superMarkets){
        for (int i = 0; i < superMarkets.size(); i++) {
            SuperMarket superMarket = superMarkets.get(i);
            for (int j = 0; j < superMarket.getItems().size(); j++) {
                for (int k = 0; k < superMarket.getItems().size() - j - 1; k++){
                    if (superMarket.getItems().get(k+1).getPrice() > superMarket.getItems().get(k).getPrice()) {
                        itemSwap(i,k,k+1,superMarkets);
                    }
                }
            }
        }
    }

    private void sortItemsByPriceAscending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            SuperMarket superMarket = superMarkets.get(i);
            for (int j = 0; j < superMarket.getItems().size(); j++) {
                for (int k = 0; k < superMarket.getItems().size() - j - 1; k++) {
                    if (superMarket.getItems().get(k+1).getPrice() < superMarket.getItems().get(k).getPrice()) {
                        itemSwap(i,k,k+1,superMarkets);
                    }
                }
            }
        }
    }

    private void sortItemsByNumberDescending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            SuperMarket superMarket = superMarkets.get(i);
            for (int j = 0; j < superMarket.getItems().size(); j++) {
                for (int k = 0; k < superMarket.getItems().size() - j - 1; k++) {
                    if (superMarket.getItems().get(k+1).getNumbers() > superMarket.getItems().get(k).getNumbers()) {
                        itemSwap(i,k,k+1,superMarkets);
                    }
                }
            }
        }
    }

    private void itemSwap(int fruitShop,int first,int second,ArrayList<SuperMarket> superMarkets){
        SuperMarket superMarket = superMarkets.get(fruitShop);
        Item temp = superMarket.getItems().get(first);
        superMarket.getItems().set(first, superMarkets.get(fruitShop).getItems().get(second));
        superMarket.getItems().set(second, temp);
    }

    private void sortItemsByNumberAscending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            SuperMarket superMarket = superMarkets.get(i);
            for (int j = 0; j < superMarket.getItems().size(); j++) {
                for (int k = 0; k < superMarket.getItems().size() - j - 1; k++) {
                    if (superMarket.getItems().get(k+1).getNumbers() < superMarket.getItems().get(k).getNumbers()) {
                        itemSwap(i,k,k+1,superMarkets);
                    }
                }
            }
        }
    }

    private void sortSuperMarketByIdeaDescending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            for (int j = 0; j < superMarkets.size()- i - 1; j++) {
                if (superMarkets.get(j+1).getComments().size() > superMarkets.get(j).getComments().size()) {
                    superMarketSwap(j,j+1,superMarkets);
                }
            }
        }
    }

    private void sortSuperMarketByIdeaAscending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            for (int j = 0; j < superMarkets.size()- i - 1; j++) {
                if (superMarkets.get(j+1).getComments().size() < superMarkets.get(j).getComments().size()) {
                    superMarketSwap(j,j+1,superMarkets);
                }
            }
        }
    }

    private void sortSuperMarketByStarDescending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            for (int j = 0; j < superMarkets.size()- i - 1; j++) {
                if (superMarkets.get(j+1).getStar() > superMarkets.get(j).getStar()) {
                    superMarketSwap(j,j+1,superMarkets);
                }
            }
        }
    }

    private void superMarketSwap(int first,int second,ArrayList<SuperMarket> superMarkets){
        SuperMarket temp = superMarkets.get(first);
        superMarkets.set(first,superMarkets.get(second));
        superMarkets.set(second,temp);
    }

    private void sortSuperMarketByStarAscending(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            for (int j = 0; j < superMarkets.size()- i - 1; j++) {
                if (superMarkets.get(j+1).getStar() < superMarkets.get(j).getStar()) {
                    superMarketSwap(j,j+1,superMarkets);
                }
            }
        }
    }

    private void printSortOfItem(){
        System.out.println("1 : Sort by numbers Ascending");
        System.out.println("2 : Sort by Numbers Descending");
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
