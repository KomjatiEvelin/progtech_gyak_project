package hu.komjati.products;
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
        return "ID :"+this.getID()+" NAME:"+this.getName()+" PRICE:"+this.getPrice()+" TYPE:"+this.getType()+" EXPIRE DAY: "+this.getExpDay();
    }

    private String getExpDay() {
        return  this.expireDay.toString();
    }

    private GroceryType getType() {
        return this.type;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public UUID getID() {
        return this.ID;
    }
}
