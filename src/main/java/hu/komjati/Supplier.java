package hu.komjati;

import java.util.List;
import java.util.UUID;

public interface Supplier {

    UUID getID();
    String getName();
    void Supply(List<Product> prods, Warehouse w);
}
