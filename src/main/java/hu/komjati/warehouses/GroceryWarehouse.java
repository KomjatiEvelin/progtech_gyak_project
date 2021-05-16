package hu.komjati.warehouses;


import hu.komjati.databases.CustomerDB;
import hu.komjati.databases.OrderDB;
import hu.komjati.databases.ProductDB;
import hu.komjati.databases.SupplierDB;
import hu.komjati.orders.OrderImpl;
import hu.komjati.customers.Customer;
import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.suppliers.GrocerySupplier;
import hu.komjati.suppliers.Supplier;
import java.util.List;
import java.util.UUID;

public class GroceryWarehouse implements Warehouse {

    private static GroceryWarehouse groceryWarehouse=null;

    private final CustomerDB customers;
    private final ProductDB products;
    private final SupplierDB suppliers;
    private final OrderDB orders;

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
    public void addProduct(Product p) throws Exception {

        if(p instanceof Grocery)
            this.products.addProduct(p);
        else throw new Exception("Ilyen áruval nem foglalkozunk");
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

        if(!IsGrocerySupplier(s)) {
            throw new Exception("Csak élelmiszer beszállítókkal dolgozunk");
        }
        this.suppliers.addSupplier(s);
    }

    private boolean IsGrocerySupplier(Supplier s) {
        return s instanceof GrocerySupplier;
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
            throw new Exception("Nincs ilyen felhasználó nálunk");
        }
        if(!isProductsInWarehouse(o.getOrderedProds())){
            throw new Exception("Ezek a termékek nem kaphatóak");
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
    public List<OrderImpl> getAllOrder() {
        return this.orders.getAllOrder();
    }

    @Override
    public OrderImpl getOrderByID(UUID ID) {
        return this.orders.getOrderByID(ID);
    }
}
