package ir.ac.kntu.menu.sorting;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.market.Restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class RestaurantSorting {
    public RestaurantSorting(ArrayList<Restaurant> restaurants) {
        restaurantSorting(restaurants);
    }

    private void restaurantSorting(ArrayList<Restaurant> restaurants){
        System.out.println("Please chose the Restaurant 's sorting");
        printSortOfMarket();
        sortRestaurant(selector(4,1),restaurants);
        System.out.println("Please chose the Food 's sorting");
        printSortOfStuff();
        sortFood(selector(restaurants.size(),0),restaurants);
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

    private void sortRestaurant(int choice, ArrayList<Restaurant> restaurants) {
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
