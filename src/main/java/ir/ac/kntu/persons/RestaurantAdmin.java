package ir.ac.kntu.persons;

import ir.ac.kntu.market.Restaurant;

import java.util.Objects;

public class RestaurantAdmin extends Admin {

    private Restaurant restaurant;

    public RestaurantAdmin(String name, String password, Restaurant restaurant) {
        super(name, password);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean checkRestaurantAdmin(RestaurantAdmin restaurantAdmin){
        if (!this.getName().equals(restaurantAdmin.getName())){
            System.out.println("The Wrong name was used");
            return false;
        } else if (!this.getPassword().equals(restaurantAdmin.getPassword())) {
            System.out.println("Wrong password");
            return false;
        } else if (!this.restaurant.equals(restaurantAdmin.getRestaurant())) {
            System.out.println("this Admin doesn't own this Super Market");
            return false;
        }
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
