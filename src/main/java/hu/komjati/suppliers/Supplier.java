package hu.komjati.suppliers;

import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;


import java.util.UUID;

public interface Supplier {

    UUID getID();
    String getName();
    void Supply(Product prod, Warehouse w) throws Exception;
}
