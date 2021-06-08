package ir.ac.kntu.menu;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Fruit;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;
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
            restaurantSorting(restaurants);
        } else if (choice == 2) {
            fruitShopSorting(fruitShops);
        } else if (choice == 3) {
            superMarketSorting(superMarkets);
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

    private void restaurantSorting(ArrayList<Restaurant> restaurants){
        System.out.println("Please chose the Restaurant 's sorting");
        printSortOfMarket();
        sortRestaurant(selector(4,1),restaurants);
        System.out.println("Please chose the Food 's sorting");
        printSortOfStuff();
        sortFood(selector(restaurants.size(),0),restaurants);
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

    private void sortRestaurant(int choice,ArrayList<Restaurant> restaurants) {
        if (choice == 1) {
            sortRestaurantByStarAscending(restaurants);
        } else if (choice == 2) {
            sortRestaurantByStarDescending(restaurants);
        } else if (choice == 3) {
            sortRestaurantByIdeaAscending(restaurants);
        } else if (choice == 4) {
            sortRestaurantByIdeaDescending(restaurants);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void sortFood(int choice,ArrayList<Restaurant> restaurants) {
        if (choice == 1) {
            sortFoodByStarAscending(restaurants);
        } else if (choice == 2) {
            sortFoodByStarDescending(restaurants);
        } else if (choice == 3) {
            sortFoodByPriceAscending(restaurants);
        } else if (choice == 4) {
            sortFoodByPriceDescending(restaurants);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void restaurantSwap(int first,int second,ArrayList<Restaurant> restaurants) {
        Restaurant temp = restaurants.get(first);
        restaurants.set(first,restaurants.get(second));
        restaurants.set(second,temp);
    }

    private void sortRestaurantByStarAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getStar() < restaurants.get(j).getStar()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByStarDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getStar() > restaurants.get(j).getStar()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByIdeaAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getComments().size() < restaurants.get(j).getComments().size()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByIdeaDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getComments().size() > restaurants.get(j).getComments().size()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void foodSwap(int restaurant,int first,int second,ArrayList<Restaurant> restaurants){
        Restaurant restaurant1 = restaurants.get(restaurant);
        Food temp = restaurant1.getFoods().get(first);
        restaurant1.getFoods().set(first, restaurants.get(restaurant).getFoods().get(second));
        restaurant1.getFoods().set(second, temp);
    }

    private void sortFoodByPriceAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k+1).getPrice() < restaurant.getFoods().get(k).getPrice()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByPriceDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k+1).getPrice() > restaurant.getFoods().get(k).getPrice()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByStarAscending(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k).getStar() > restaurant.getFoods().get(k + 1).getStar()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByStarDescending(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k).getStar() < restaurant.getFoods().get(k + 1).getStar()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }
}