package hu.komjati.products;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductImpl implements Product{

    private String name;
    private int price;
    @Setter(AccessLevel.NONE)  private UUID ID;

    public ProductImpl(String name, int price) {
        this.ID=UUID.randomUUID();
        this.name = name;
        this.price = price;

    }

}
