package ir.ac.kntu.menu;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.customer.ConditionOfOrder;
import ir.ac.kntu.customer.RestaurantOrder;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.Restaurant;

import java.util.ArrayList;

public class RestaurantOrderMenu {

    public RestaurantOrderMenu(ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries,
                               ArrayList<RestaurantOrder> restaurantOrders) {
        orderMenu(restaurantOrders,restaurants,deliveries);
    }

    public void orderMenu(ArrayList<RestaurantOrder> restaurantOrders,
                          ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries){
        System.out.println("1 : Adding Order");
        System.out.println("2 : Seeing the restaurantOrders and changing the condition");
        int choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 1) {
            System.out.println("please Enter the time that you want to order");
            Time time = new Time().addTime();
            int[] choices = availableRestaurant(time,restaurants);
            if (choices.length == 0) {
                System.out.println("there is no restaurant that work at this hour");
                return;
            }
            System.out.println("Please chose the restaurant");
            choice = ScannerWrapper.getInstance().nextInt()-1;
            addOrder(time, restaurantOrders,restaurants.get(choices[choice]),deliveries);
        } else if (choice ==2) {
            ScannerWrapper.getInstance().nextLine();
            if (restaurantOrders.size() == 0) {
                System.out.println("There is no order");
                return;
            }
            for (int i = 0; i < restaurantOrders.size(); i++) {
                System.out.println(i+1 +" : " + restaurantOrders.get(i).toString());
            }
            System.out.println("if you want to change the condition of order Enter yes else press Enter");
            String select = ScannerWrapper.getInstance().nextLine();
            while (select.matches("[Yy]es|[Yy]|[Yy]ep")){
                System.out.println("Which one do you want to change");
                choice = ScannerWrapper.getInstance().nextInt();
                ScannerWrapper.getInstance().nextLine();
                restaurantOrders.set(choice-1,changeOrderCondition(restaurantOrders.get(choice-1)));
                System.out.println("if you want to change more Enter yes else press Enter");
                select = ScannerWrapper.getInstance().nextLine();
            }
        } else {
            System.out.println("Wrong Input");
        }
    }

    private int[] availableRestaurant(Time time,ArrayList<Restaurant>restaurants){
        int[] choices = new int[1000];
        int j=0;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).isAvailable(time)) {
                choices[j]=i;
                System.out.println(j + 1 +" : " + restaurants.get(i).toString());
                j++;
            }
        }
        return choices;
    }

    private void addOrder(Time time,ArrayList<RestaurantOrder> restaurantOrders,
                         Restaurant restaurant,ArrayList<Delivery>deliveries){
        ArrayList<Food> foods = restaurant.getFoods();
        printFoods(foods);
        System.out.println("Please chose the food you want");
        int select = ScannerWrapper.getInstance().nextInt() - 1;
        ScannerWrapper.getInstance().nextLine();
        RestaurantOrder restaurantOrder = new RestaurantOrder(foods.get(select), ConditionOfOrder.IN_PROCESSING);
        restaurantOrders.add(restaurantOrder);
        System.out.println("The order has been saved ," +
                " The Condition : " + ConditionOfOrder.IN_PROCESSING);
        restaurant.addComment();
        for (Delivery delivery:deliveries) {
            if (delivery.deliveryIsAvailable(time)) {
                if (delivery.addRestaurant(restaurant)) {
                    System.out.println("this restaurant has been add to this delivery\n" + delivery.toString());
                    delivery.addComment();
                    delivery.addToHistoryOfOrders(foods.get(select));
                    restaurantOrders.set(restaurantOrders.indexOf(restaurantOrder),
                            new RestaurantOrder(foods.get(select),ConditionOfOrder.IN_TRANSMISSION));
                    return;
                }
            }
        }
        System.out.println("there is no delivery at this hour");
    }

    public void printFoods(ArrayList<Food> foods) {
        if (foods.size() == 0) {
            System.out.println("there is no customer");
        }
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i+1 +" : " + foods.get(i).toString());
        }
    }

    private RestaurantOrder changeOrderCondition(RestaurantOrder restaurantOrder) {
        printChangeOrderCondition();
        int choice = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case 1:
                return new RestaurantOrder(restaurantOrder.getFood(),ConditionOfOrder.IN_PROCESSING);
            case 2:
                return new RestaurantOrder(restaurantOrder.getFood(),ConditionOfOrder.IN_TRANSMISSION);
            case 3:
                restaurantOrder.getFood();
                return new RestaurantOrder(restaurantOrder.getFood(),ConditionOfOrder.DELIVERED);
            default:
                System.out.println("Wrong Input");
                break;
        }
        return restaurantOrder;
    }

    public void printChangeOrderCondition(){
        System.out.println("which one do you want to change the condition to");
        System.out.println("1 : IN_PROCESSING");
        System.out.println("2 : IN_TRANSMISSION");
        System.out.println("3 : DELIVERED");
    }
}
