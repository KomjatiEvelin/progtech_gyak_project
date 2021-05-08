package hu.komjati;

import java.util.Date;

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
        System.out.println(p);
    }

}
