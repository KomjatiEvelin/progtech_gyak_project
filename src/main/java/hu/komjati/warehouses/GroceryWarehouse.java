package hu.komjati.warehouses;

import hu.komjati.databases.CustomerDB;
import hu.komjati.databases.OrderDB;
import hu.komjati.databases.ProductDB;
import hu.komjati.databases.SupplierDB;
import hu.komjati.orders.OrderImpl;
import hu.komjati.customers.Customer;
import hu.komjati.products.Product;
import hu.komjati.suppliers.Supplier;
import java.util.List;
import java.util.UUID;

public class GroceryWarehouse implements Warehouse {

    private static GroceryWarehouse groceryWarehouse=null;

    CustomerDB customers;
    ProductDB products;
    SupplierDB suppliers;
    OrderDB orders;

    private GroceryWarehouse(CustomerDB customers,ProductDB products,SupplierDB suppliers,OrderDB orders) {
        this.products = products;
        this.customers=customers;
        this.suppliers=suppliers;
        this.orders=orders;
    }

    public static GroceryWarehouse getInstance(CustomerDB customers,ProductDB products,SupplierDB suppliers,OrderDB orders){
        if(groceryWarehouse==null){
            groceryWarehouse=new GroceryWarehouse(customers,products,suppliers,orders);
        }
        return groceryWarehouse;
    }

    @Override
    public void addProduct(Product p) {
        this.products.addProduct(p);
    }

    @Override
    public List<Product> getProductsList() {
        return this.products.getProductsList();
    }

    @Override
    public Product getProductByID(UUID ID) {
        return this.products.getProductByID(ID);
    }


    @Override
    public void addSupplier(Supplier s) {
        this.suppliers.addSupplier(s);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return this.suppliers.getAllSuppliers();
    }

    @Override
    public Supplier getSupplierByID(UUID ID) {
       return this.suppliers.getSupplierByID(ID);
    }

    @Override
    public void addCustomer(Customer c) {

        this.customers.addCustomer(c);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return  this.customers.getAllCustomers();
    }

    @Override
    public Customer getCustomerByID(UUID ID) {
       return this.customers.getCustomerByID(ID);
    }

    @Override
    public boolean recordNewOrder(OrderImpl o) {

        if(this.customers.getAllCustomers().contains(o.getCustomer())&&this.products.getProductsList().containsAll(o.getOrderedProds())){ //TODO kiemelni külön vizsgálatba
            this.orders.recordNewOrder(o);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderImpl> getAllOrder() {
        return this.orders.getAllOrder();
    }

    @Override
    public OrderImpl getOrderByID(UUID ID) {
        return this.orders.getOrderByID(ID);
    }
}
