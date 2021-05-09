package hu.komjati;

import hu.komjati.groceries.GroceriesSupplier;
import hu.komjati.groceries.Grocery;
import hu.komjati.groceries.GroceryType;
import hu.komjati.groceries.GroceryWarehouse;
import hu.komjati.interfaces.Customer;
import hu.komjati.interfaces.Product;
import hu.komjati.interfaces.Supplier;
import hu.komjati.interfaces.Warehouse;

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

        Warehouse w=new GroceryWarehouse();

        Supplier gs=new GroceriesSupplier("Goods");
        w.addSupplier(gs);

        List<Product> products=new ArrayList<>();
        for (int i=0;i<10;i++){
            products.add(new Grocery("product"+i,i*rnd.nextInt(100),new Date(), GroceryType.fruit));
        }
        gs.Supply(products,w);


        ListaKiir(w.getProductsList());

        Customer c= new CustomerImplBuilder().setName("Joe").setAddress("3010 Shell str. 43").createCustomerImpl();
        w.addCustomer(c);

        System.out.println(w.getCustomerByID(c.getID()).toString());

    }

    static void ListaKiir(List l){
        for (Object o:l) {
            System.out.println(o.toString());
        }
    }

}
