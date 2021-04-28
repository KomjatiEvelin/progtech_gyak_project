package hu.komjati;


import java.util.List;

public interface Warehouse {

   boolean addProduct(Product p);
   List<Product> getProductsList();
    Product getProductByID(int ID);

   boolean recordNewOrder(Order o);
    List<Order> getAllOrder();
    Order getOrderByID(int ID);

    boolean addSupplier(Supplier s);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierByID(int ID);

    boolean addCustomer(Customer c);
    List<Customer> getAllCustomers();
    Customer getCustomerByID(int ID);
}
