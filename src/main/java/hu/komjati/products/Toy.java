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

    public Toy(String name, int price,int ageLimit) {
        this.name = name;
        this.price = price;
        this.ageLimit=ageLimit;
    }

    @Override
    public String toString() {
        return this.name+":"+this.price+" HUF : Over age "+this.ageLimit;
    }
}
