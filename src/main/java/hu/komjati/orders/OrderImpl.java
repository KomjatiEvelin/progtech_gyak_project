package hu.komjati.orders;

import hu.komjati.customers.Customer;
import hu.komjati.products.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Singular;

@Getter
public class OrderImpl implements Order{

    private final Customer customer;
    @Singular private final List<Product> orderedProds;
    private final UUID ID;
    private final Date recordTime;

    public OrderImpl(Customer customer, List<Product> cart) {
        this.ID=UUID.randomUUID();
        this.customer=customer;
        this.orderedProds=cart;
        this.recordTime=new Date();
    }



    @Override
    public String toString() {
        StringBuilder text= new StringBuilder();
        text.append("\n-----ORDERED PRODUCTS by ").append(this.customer.toString()).append(" ------\n");
        for (Product p:orderedProds) {
            text.append("\n").append(p.toString());
        }
        text.append("\n\n-----").append(this.ID).append("----").append(this.recordTime).append("--------");
        return text.toString();
    }
}
