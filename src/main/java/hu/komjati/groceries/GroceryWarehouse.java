package hu.komjati.groceries;



import hu.komjati.Order;
import hu.komjati.SupplierImpl;
import hu.komjati.interfaces.Customer;
import hu.komjati.interfaces.Product;
import hu.komjati.interfaces.Supplier;
import hu.komjati.interfaces.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroceryWarehouse implements Warehouse {

    private List<Grocery> products;
    private List<Customer> customers;
    private List<Supplier> suppliers;
    private List<Order> orders;

    public GroceryWarehouse() {
        this.products = new ArrayList<>();
        this.customers=new ArrayList<>();
        this.suppliers=new ArrayList<>();
        this.orders=new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product p) {
        if(p instanceof Grocery && !products.contains(p)){
            this.products.add((Grocery)p);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getProductsList() {
        List<Product> temp=new ArrayList<>();
        for (Grocery p:products) {
            temp.add(p);
        }
        return temp;
    }

    @Override
    public Product getProductByID(UUID ID) {
        for (Grocery p:products) {
            if(p.getID()==ID){
                return p;
            }
        }
        return null;

    }


    @Override
    public boolean addSupplier(Supplier s) {
        if(s instanceof SupplierImpl && !suppliers.contains(s)){
            this.suppliers.add(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> temp=new ArrayList<>();
        for (Supplier s:suppliers) {
            temp.add(s);
        }
        return temp;
    }

    @Override
    public Supplier getSupplierByID(UUID ID) {
        for (Supplier s:suppliers) {
            if(s.getID()==ID){
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer c) {

            this.customers.add(c);
            return true;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> temp=new ArrayList<>();
        for (Customer c:customers) {
            temp.add(c);
        }
        return temp;
    }

    @Override
    public Customer getCustomerByID(UUID ID) {
        for (Customer c:customers) {
            if(c.getID()==ID){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean recordNewOrder(Order o) {

        if(this.customers.contains(o.getCustomer())&&this.products.containsAll(o.getPrdoucts())){
            orders.add(o);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> temp=new ArrayList<>();
        for (Order o:orders) {
            temp.add(o);
        }
        return temp;
    }

    @Override
    public Order getOrderByID(UUID ID) {
        for (Order o:orders) {
            if(o.getID()==ID){
                return o;
            }
        }
        return null;
    }
}
