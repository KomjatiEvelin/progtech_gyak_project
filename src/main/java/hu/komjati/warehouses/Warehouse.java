package hu.komjati.warehouses;


import hu.komjati.orders.OrderImpl;
import hu.komjati.customers.Customer;
import hu.komjati.suppliers.Supplier;
import hu.komjati.products.Product;

import java.util.List;
import java.util.UUID;

public interface Warehouse {

    void addProduct(Product p);
    List<Product> getProductsList();
    Product getProductByID(UUID ID);


   boolean recordNewOrder(OrderImpl o);
    List<OrderImpl> getAllOrder();
    OrderImpl getOrderByID(UUID ID);


    void addCustomer(Customer c);
    List<Customer> getAllCustomers();
    Customer getCustomerByID(UUID ID);

    void addSupplier(Supplier s);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierByID(UUID ID);
}
