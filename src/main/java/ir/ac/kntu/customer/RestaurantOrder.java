package ir.ac.kntu.customer;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Stuff;


public class RestaurantOrder {

    private Food food;

    private ConditionOfOrder conditionOfOrder;

    public RestaurantOrder(Food food, ConditionOfOrder conditionOfOrder) {
        this.food = food;
        this.conditionOfOrder = conditionOfOrder;
    }

    @Override
    public String toString() {
        return "Order { " +
                "stuff = " + food +
                ", conditionOfOrder = " + conditionOfOrder +
                " }";
    }

    public Food getFood() {
        return food;
    }
}