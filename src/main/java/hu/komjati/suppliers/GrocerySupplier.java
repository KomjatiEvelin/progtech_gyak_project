package hu.komjati.suppliers;

import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class GrocerySupplier implements Supplier {

    private final UUID ID;
    private final String name;

    public GrocerySupplier(String name) {
        this.ID = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public void Supply(Product prod, Warehouse w) throws Exception {
        if(!SupplierRegisteredInTheWarehouse(w)) {
            throw new Exception("Ez a beszállító nincs a rendszerben, előbb regisztrálja");
        }

        if(!ProductIsGrocery(prod))
        {
            throw new Exception("Mi nem foglalkozunk ilyen áruval");
        }
        w.addProduct(prod);

        System.out.println(this.getName() + " supplied " + prod.getName() + " product " + new Date());

    }

    private boolean SupplierRegisteredInTheWarehouse(Warehouse w){
        return w.getSupplierByID(this.ID) != null;
    }

    private boolean ProductIsGrocery(Product p){
        return p instanceof Grocery;
    }
}
