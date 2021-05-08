package hu.komjati;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GrocerieWarehouse implements Warehouse {

    private List<Grocery> products;
    private List<Customer> customers;
    private List<Supplier> suppliers;
    private List<Order> orders;

    public GrocerieWarehouse() {
        this.products = new ArrayList<>();
        this.customers=new ArrayList<>();
        this.suppliers=new ArrayList<>();
        this.orders=new ArrayList<>();
    }

    @Override
    public boolean addProduct(Product p) {
        if(p instanceof Grocery){
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
        return false;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return null;
    }

    @Override
    public Supplier getSupplierByID(UUID ID) {
        return null;
    }

    @Override
    public boolean addCustomer(Customer c) {
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerByID(UUID ID) {
        return null;
    }

    @Override
    public boolean recordNewOrder(Order o) {
        return false;
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public Order getOrderByID(UUID ID) {
        return null;
    }
}
