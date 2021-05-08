package hu.komjati;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Product p=new Grocery("teszt",10000, new Date(),GroceryType.meat);
        Product p1=new Grocery("teszt1",2345, new Date(),GroceryType.dairy);
        Product p2=new Grocery("teszt2",2345, new Date(),GroceryType.grain);
        Warehouse w=new GrocerieWarehouse();

        List<Product> products=new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        Supplier gs=new GroceriesSupplier("Goods");
        gs.Supply(products,w);
        List<Product>prods=w.getProductsList();

        for (Product x:prods) {
            System.out.println(x.toString());
        }
    }

}
