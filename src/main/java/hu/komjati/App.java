package hu.komjati;

import hu.komjati.customers.CustomerImplBuilder;
import hu.komjati.databases.*;
import hu.komjati.databases.memoryDBs.MemoryCustomerDB;
import hu.komjati.databases.memoryDBs.MemoryOrderDB;
import hu.komjati.databases.memoryDBs.MemoryProductDB;
import hu.komjati.databases.memoryDBs.MemorySuppliersDB;
import hu.komjati.products.Grocery;
import hu.komjati.products.GroceryType;
import hu.komjati.suppliers.SupplierImpl;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.customers.Customer;
import hu.komjati.products.Product;
import hu.komjati.suppliers.Supplier;
import hu.komjati.warehouses.Warehouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class  App
{

    static Random rnd=new Random();
    public static void main( String[] args )
    {
        CustomerDB customers=new MemoryCustomerDB();
        ProductDB products=new MemoryProductDB();
        SupplierDB suppliers=new MemorySuppliersDB();
        OrderDB orders=new MemoryOrderDB();

        Warehouse w=new GroceryWarehouse(customers,products,suppliers,orders);

        Supplier gs=new SupplierImpl("Goods");
        w.addSupplier(gs);

        List<Product> suppliedProducts=new ArrayList<>();
        for (int i=0;i<10;i++){
            suppliedProducts.add(new Grocery("product"+i,i*rnd.nextInt(100),new Date(), GroceryType.fruit));
        }
        gs.Supply(suppliedProducts,w);


        ListaKiir(w.getProductsList());

        Customer c= new CustomerImplBuilder().setName("Joe").setAddress("3010 Shell str. 43").createCustomerImpl();
        w.addCustomer(c);

        System.out.println(w.getCustomerByID(c.getID()).toString());

        for (Product p:suppliedProducts) {
            if(p.getPrice()%2!=0)
            c.addToCart(p);
        }
        c.orderProducts(w);

        ListaKiir(w.getAllOrder());

    }

    static void ListaKiir(List l){
        for (Object o:l) {
            System.out.println(o.toString());
        }
    }

}
