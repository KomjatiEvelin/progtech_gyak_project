package hu.komjati.suppliers;

import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.*;

@Getter
public class SupplierImpl implements Supplier {

    private UUID ID;
    private String name;

    public SupplierImpl(String name) {
        this.ID = UUID.randomUUID();
        this.name = name;
    }


    @Override
    public void Supply(List<Product> prods, Warehouse w) {

        if(w.getSupplierByID(this.ID)!=null) {
            for (Product product : prods) {
                w.addProduct(product);
            }
            System.out.println(this.getName() + " supplied " + prods.size() + " product(s) " + new Date());
        }
        else System.out.println("Ez a beszállító nincs a rendszerben, előbb regisztrálja");

    }
}
