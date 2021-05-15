package hu.komjati.orders;

import hu.komjati.customers.Customer;
import hu.komjati.products.Product;

import java.util.List;

public class OrderBuilder {
    private Customer customer;
    private List<Product> cart;

    public OrderBuilder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder setCart(List<Product> cart) {
        this.cart = cart;
        return this;
    }

    public Order createOrder() {
        return new Order(customer, cart);
    }
}