package hu.komjati;

import java.util.Date;
import java.util.UUID;

public class Grocery implements Product {


    private UUID ID;
    private String name;
    private int price;
    private Date expireDay;
    private GroceryType type;

    public Grocery(String name, int price, Date expireDay, GroceryType type) {
        this.ID=UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.expireDay = expireDay;
        this.type = type;
    }


    @Override
    public String toString(){
        return this.ID+":"+this.name+":"+this.price+":"+this.expireDay.toString()+":"+this.type;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public UUID getID() {
        return null;
    }
}
