package hu.komjati.products;
import java.util.Date;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@ToString
public class Grocery implements Product {


    private String name;
    private int price;
    private Date expireDay;
    private GroceryType type;

    @Setter(AccessLevel.NONE)  private UUID ID;


    public Grocery(String name, int price, Date expireDay, GroceryType type) {
        this.ID=UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.expireDay = expireDay;
        this.type = type;
    }

}
