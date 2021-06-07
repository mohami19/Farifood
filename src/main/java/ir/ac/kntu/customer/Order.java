package ir.ac.kntu.customer;

import ir.ac.kntu.Stuff.Stuff;

public class Order {

    private Stuff stuff;

    private ConditionOfOrder conditionOfOrder;

    public Order(Stuff stuff, ConditionOfOrder conditionOfOrder) {
        this.stuff = stuff;
        this.conditionOfOrder = conditionOfOrder;
    }

    @Override
    public String toString() {
        return "Order { " +
                "stuff = " + stuff +
                ", conditionOfOrder = " + conditionOfOrder +
                " }";
    }
}