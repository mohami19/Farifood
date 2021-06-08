package ir.ac.kntu.customer;

import ir.ac.kntu.manager.Address;
import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String telephoneNumber;

    private Address address;

    private final ArrayList<RestaurantOrder> restaurantOrders;

    public Customer(String telephoneNumber, Address address) {
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        restaurantOrders = new ArrayList<>();
    }

    public void addOrder(RestaurantOrder restaurantOrder) {
        restaurantOrders.add(restaurantOrder);
    }

    @Override
    public String toString() {
        return "Customer { " +
                "telephoneNumber = '" + telephoneNumber + '\'' +
                ", address = " + address +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(telephoneNumber, customer.telephoneNumber)
                && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephoneNumber, address);
    }
}