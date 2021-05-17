package hu.komjati;

import hu.komjati.customers.Customer;
import hu.komjati.customers.CustomerImpl;
import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.products.Toy;
import hu.komjati.suppliers.GrocerySupplier;
import hu.komjati.suppliers.Supplier;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.Warehouse;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SupplierTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getIDTest(){
        //given
        Supplier s =mock(Supplier.class);
        when(s.getID()).thenReturn(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
        //when
        UUID returnedID=s.getID();
        //then
        verify(s,times(1)).getID();
        assertEquals(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"),returnedID);

    }


    @Test
    public void getAndSetNameTest(){


        Supplier s =mock(Supplier.class);
        String testName="Test Name";
        when(s.getName()).thenReturn(testName);


        verify(s,times(1)).getName();
        assertEquals(testName,s.getName());
    }

    @Test
    public void succesfullSuply() throws Exception {
        Warehouse w=mock(GroceryWarehouse.class);
        Supplier s=mock(GrocerySupplier.class);
        Product p=mock(Grocery.class);
        w.addSupplier(s);
        s.Supply(p,w);

        verify(s,times(1)).Supply(p,w);
    }



}
