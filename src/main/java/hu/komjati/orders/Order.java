package hu.komjati.orders;

import hu.komjati.customers.Customer;
import hu.komjati.products.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface Order {
    Customer getCustomer();
    List<Product> getOrderedProds();
    Date getRecordTime();
    UUID getID();


}
