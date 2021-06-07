package ir.ac.kntu.Manager;

import java.util.Objects;

public class Address {
    private String street;

    private String plaque;

    public Address() {
    }

    public Address(String street, String plaque) {
        this.street = street;
        this.plaque = plaque;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public Address addAddress(){
        System.out.println("PLease Enter the Address");
        System.out.println("Please enter the Street :  ");
        String street = ScannerWrapper.getInstance().nextLine();
        System.out.println("Please enter the plaque :  ");
        String plaque = ScannerWrapper.getInstance().nextLine();
        return new Address(street,plaque);
    }

    @Override
    public String toString() {
        return "Address { " + "street =" + street +" , plaque = " + plaque + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(plaque, address.plaque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, plaque);
    }
}