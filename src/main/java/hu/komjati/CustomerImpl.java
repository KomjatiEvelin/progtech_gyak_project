package hu.komjati;

import hu.komjati.groceries.GroceriesSupplier;
import hu.komjati.groceries.Grocery;
import hu.komjati.interfaces.Customer;
import hu.komjati.interfaces.Product;
import hu.komjati.interfaces.Warehouse;

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
        this.myCart=new ArrayList<>();
        this.ID=UUID.randomUUID();
        this.address=address;
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
        this.name=name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address=address;
    }

    @Override
    public void orderProducts(List<Product> p, Warehouse w) {
        w.recordNewOrder(new Order(this,myCart));
    }


    @Override
    public void addToCart(Product p) {
        myCart.add(p);

    }

    @Override
    public String toString() {
        return this.name+" - "+this.address;
    }
}
