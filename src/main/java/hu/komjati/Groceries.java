package hu.komjati;

import java.util.Date;
import java.util.UUID;

public class Groceries implements Product {


    private UUID ID;
    private String name;
    private int price;
    private Date expireDay;
    private GroceryType type;
    @Override
    public Product getProduct() {
        return this;
    }


}
