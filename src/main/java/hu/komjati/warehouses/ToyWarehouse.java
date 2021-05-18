package hu.komjati.warehouses;


import hu.komjati.databases.CustomerDB;
import hu.komjati.databases.OrderDB;
import hu.komjati.databases.ProductDB;
import hu.komjati.databases.SupplierDB;
import hu.komjati.orders.Order;
import hu.komjati.orders.OrderImpl;
import hu.komjati.customers.Customer;
import hu.komjati.products.Product;
import hu.komjati.products.Toy;
import hu.komjati.suppliers.Supplier;
import hu.komjati.suppliers.ToySupplier;

import java.util.List;
import java.util.UUID;

public class ToyWarehouse implements Warehouse {

    private static ToyWarehouse toyWarehouse=null;

    private final CustomerDB customers;
    private final ProductDB products;
    private final SupplierDB suppliers;
    private final OrderDB orders;

    private ToyWarehouse(CustomerDB customers,ProductDB products,SupplierDB suppliers,OrderDB orders) {
        this.products = products;
        this.customers=customers;
        this.suppliers=suppliers;
        this.orders=orders;
    }

    public static ToyWarehouse getInstance(CustomerDB customers,ProductDB products,SupplierDB suppliers,OrderDB orders){
        if(toyWarehouse==null){
           toyWarehouse=new ToyWarehouse(customers,products,suppliers,orders);
        }
        return toyWarehouse;
    }

    @Override
    public void addProduct(Product p) throws Exception {

        if(p instanceof Toy)
            this.products.addProduct(p);
        else throw new Exception("This product type is not our profile");
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
    public void addSupplier(Supplier s) throws Exception {

        if(!IsToySupplier(s)) {
            throw new Exception("We only work with  ToySuppliers");
        }
        this.suppliers.addSupplier(s);
    }

    private boolean IsToySupplier(Supplier s) {
        return s instanceof ToySupplier;
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
    public void recordNewOrder(OrderImpl o) throws Exception {

        if(!isCustomerRegistered(o.getCustomer())){
            throw new Exception("Customer not found");
        }
        if(!isProductsInWarehouse(o.getOrderedProds())){
            throw new Exception("Product not found");
        }
        this.orders.recordNewOrder(o);
    }

    private boolean isCustomerRegistered(Customer c){
        return this.customers.getAllCustomers().contains(c);
    }

    private boolean isProductsInWarehouse(List<Product> products){
        return this.products.getProductsList().containsAll(products);
    }

    @Override
    public List<Order> getAllOrder() {
        return this.orders.getAllOrder();
    }

    @Override
    public Order getOrderByID(UUID ID) {
        return this.orders.getOrderByID(ID);
    }
}
