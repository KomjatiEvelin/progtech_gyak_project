package hu.komjati;


import java.util.List;
import java.util.UUID;

public interface Warehouse {

   boolean addProduct(Product p);
   List<Product> getProductsList();
    Product getProductByID(UUID ID);

   boolean recordNewOrder(Order o);
    List<Order> getAllOrder();
    Order getOrderByID(UUID ID);

    boolean addSupplier(Supplier s);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierByID(UUID ID);

    boolean addCustomer(Customer c);
    List<Customer> getAllCustomers();
    Customer getCustomerByID(UUID ID);
}
