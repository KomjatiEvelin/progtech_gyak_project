package hu.komjati.products;
import java.util.Date;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
public class Grocery implements Product {


    private String name;
    private int price;
    @Setter(AccessLevel.NONE)  private UUID ID;
    private Date expireDay;
    @Setter(AccessLevel.NONE) private GroceryType type;

    public Grocery(String name, int price,Date expireDay) {
        this.name = name;
        this.price = price;
        this.expireDay=expireDay;
        this.ID=UUID.randomUUID();
        this.type=GroceryType.other;
    }

    @Override
    public String toString() {
        return "Grocery : "+this.name+" : "+this.price+" HUF : "+this.expireDay;
    }
}
