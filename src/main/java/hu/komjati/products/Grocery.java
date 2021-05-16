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
    @Setter(AccessLevel.NONE)  private UUID ID;
    private Date expireDay;
    private GroceryType type;


    private final Product p;


    public Grocery(Product p) {
       this.p=p;
       this.name=p.getName();
       this.price=p.getPrice();
       this.ID=p.getID();
       this.expireDay=new Date();
       this.type=GroceryType.other;
    }

}
