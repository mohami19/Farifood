package ir.ac.kntu.Stuff;

public class Item extends Stuff {
    private int numbers;

    public Item(String name, double price, double star, int numbers) {
        super(name, price, star);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Fruit { " +
                "numbers of fruit = " + numbers +
               " }";
    }
}
