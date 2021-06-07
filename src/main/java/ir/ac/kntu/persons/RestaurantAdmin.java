package ir.ac.kntu.persons;

import ir.ac.kntu.market.Restaurant;

import java.util.Objects;

public class RestaurantAdmin extends Admin {

    private Restaurant restaurant;

    public RestaurantAdmin(String name, String password, Restaurant restaurant) {
        super(name, password);
        this.restaurant = restaurant;
    }

    public boolean checkRestaurantAdminInformation(String userName, String password) {
        if (!getName().equals(userName)) {
            System.out.println("Wrong Username");
            return false;
        }
        if (!this.getPassword().equals(password)) {
            System.out.println("Wrong Password");
            return false;
        }
        System.out.println("Login was successful");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        RestaurantAdmin that = (RestaurantAdmin) o;
        return Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), restaurant);
    }
}
