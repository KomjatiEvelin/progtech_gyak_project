package hu.komjati;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import hu.komjati.products.Grocery;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void succesfullAddProductToWarehouse(){
        //given
        Warehouse w=mock(GroceryWarehouse.class);

        Product p=mock(Grocery.class);
        //when
        //w.addProduct(p);
        //then
        //verify(w,times(1)).addProduct(p);

    }



}
