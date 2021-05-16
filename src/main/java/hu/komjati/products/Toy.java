package hu.komjati.products;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class Toy implements Product{

    private String name;
    private int price;
    @Setter(AccessLevel.NONE)  private UUID ID;
    private int ageLimit;

    private final Product p;


    public Toy(Product p) {
        this.p=p;
        this.name=p.getName();
        this.price=p.getPrice();
        this.ID=p.getID();
        this.ageLimit=0;
    }
}
