package ir.ac.kntu.Customer;

import ir.ac.kntu.Manager.Address;
import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String telephoneNumber;

    private Address address;


    private ArrayList<String> comments;

    private ArrayList<Order> orders;


    public Customer(String telephoneNumber, Address address) {
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        orders= new ArrayList<>();
        comments = new ArrayList<>();
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