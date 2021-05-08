package hu.komjati.groceries;

import hu.komjati.interfaces.Product;
import hu.komjati.interfaces.Supplier;
import hu.komjati.interfaces.Warehouse;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GroceriesSupplier implements Supplier {

    private UUID ID;
    private String name;

    public GroceriesSupplier(String name) {
        this.ID = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public UUID getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void Supply(List<Product> prods, Warehouse w) {

        for (Product product : prods) {
            w.addProduct(product);
        }
        System.out.println(this.getName()+" supplied "+prods.size()+" product(s) "+ new Date());

    }
}
