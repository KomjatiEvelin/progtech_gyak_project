package hu.komjati;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import hu.komjati.groceries.Grocery;
import hu.komjati.groceries.GroceryWarehouse;
import hu.komjati.interfaces.Product;
import hu.komjati.interfaces.Warehouse;
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
        when(w.addProduct(p)).thenReturn(true);
        //when
        boolean succes=w.addProduct(p);
        //then
        verify(w,times(1)).addProduct(p);
        assertTrue(succes);

    }

    @Test
    public void failAddProductToWarehouse(){
        //given
        Warehouse w=mock(GroceryWarehouse.class);
        Product p=mock(Product.class);
        when(w.addProduct(p)).thenReturn(false);
        //when
        boolean succes=w.addProduct(p);
        //then
        verify(w,times(1)).addProduct(p);
        assertFalse(succes);
    }

    @Test
    public void getProdByIDSuccess(){
        //given
        Warehouse w=mock(GroceryWarehouse.class);
        Product p=mock(Grocery.class);
        w.addProduct(p);
        //when

    }

}
