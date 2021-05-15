package hu.komjati.customers;


import hu.komjati.orders.OrderBuilder;
import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerImpl implements Customer {

    private List<Product> myCart;
    private UUID ID;
    private String name;
    private String address;

    public CustomerImpl(String name, String address) {
        this.name = name;
        this.myCart = new ArrayList<>();
        this.ID = UUID.randomUUID();
        this.address = address;
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void orderProducts(Warehouse w) {
        w.recordNewOrder(new OrderBuilder().setCustomer(this).setCart(myCart).createOrder());
    }


    @Override
    public void addToCart(Product p) {
        myCart.add(p);

    }

    @Override
    public String toString() {
        return this.name + " - " + this.address;
    }
}
