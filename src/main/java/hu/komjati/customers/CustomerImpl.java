package hu.komjati.customers;

import hu.komjati.orders.OrderBuilder;
import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerImpl implements Customer {

    private List<Product> myCart;

    @Setter(AccessLevel.NONE) private UUID ID;

    private String name;
    private String address;

    public CustomerImpl(String name, String address) {
        this.name = name;
        this.myCart = new ArrayList<>();
        this.ID = UUID.randomUUID();
        this.address = address;
    }


    @Override
    public void orderProducts(Warehouse w) throws Exception {
        try {
            w.recordNewOrder(new OrderBuilder().setCustomer(this).setCart(myCart).createOrder());
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


    @Override
    public void addToCart(Product p) {
        myCart.add(p);

    }

    @Override
    public List<Product> getProdutsInCart() {
        return this.myCart;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.address;
    }
}
