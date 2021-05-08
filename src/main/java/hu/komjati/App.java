package hu.komjati;

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

        w.addProduct(p);
        w.addProduct(p1);
        boolean s=w.addProduct(p2);
        List<Product>prods=w.getProductsList();

        for (Product x:prods) {
            System.out.println(x.toString());
        }
        System.out.println(s);
    }

}
