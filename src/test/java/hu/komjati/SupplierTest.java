package hu.komjati;

import hu.komjati.products.Grocery;
import hu.komjati.products.Toy;
import hu.komjati.suppliers.GrocerySupplier;
import hu.komjati.suppliers.Supplier;
import hu.komjati.suppliers.ToySupplier;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.ToyWarehouse;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class SupplierTest {

    @Mock
    GroceryWarehouse gw;

    @Mock
    ToyWarehouse tw;

    @Mock
    Toy toy;

    @Mock
    Grocery grocery;

    @Test
    public void testGrocerySupplierGetName(){
        Supplier s=new GrocerySupplier("GR sup");

        String name=s.getName();

        assertEquals("GR sup",name);
    }

    @Test
    public void testToySupplierGetName(){
        Supplier s=new ToySupplier("Toy sup");

        String name=s.getName();

        assertEquals("Toy sup",name);
    }

    @Test
    public void TestGrocerySupplierSupplySuccesfully() throws Exception {
        Supplier s=new GrocerySupplier("Goods");
        when(gw.getSupplierByID(s.getID())).thenReturn(s);

        s.Supply(grocery,gw);

        verify(gw, times(1)).addProduct(grocery);
    }

    @Test
    public void TestGrocerySupplierSupplyFails_CosSupplierNotRegistered() throws Exception {
        Supplier s=new GrocerySupplier("Goods");

        Throwable exception = assertThrows(Exception.class, () ->    s.Supply(grocery,gw));
        verify(gw, times(0)).addProduct(grocery);
        assertEquals("Ez a beszállító nincs a rendszerben, előbb regisztrálja", exception.getMessage());
    }

    @Test
    public void TestGrocerySupplierSupplyFails_CosProductIsNotGrocery() throws Exception {
        Supplier s=new GrocerySupplier("Goods");
        when(gw.getSupplierByID(s.getID())).thenReturn(s);

        Throwable exception = assertThrows(Exception.class, () -> s.Supply(toy,gw));

        verify(gw, times(0)).addProduct(toy);
        assertEquals("Mi nem foglalkozunk ilyen áruval", exception.getMessage());
    }

    @Test
    public void TestToySupplierSupplySuccessfully() throws Exception {
        Supplier s=new ToySupplier("Games");
        when(tw.getSupplierByID(s.getID())).thenReturn(s);

        s.Supply(toy,tw);

        verify(tw, times(1)).addProduct(toy);
    }

    @Test
    public void TestToySupplierSupplyFails_CosSupplierNotRegistered() throws Exception {
        Supplier s=new ToySupplier("Games");

        Throwable exception = assertThrows(Exception.class, () ->    s.Supply(toy,tw));
        verify(tw, times(0)).addProduct(toy);
        assertEquals("Ez a beszállító nincs a rendszerben, előbb regisztrálja", exception.getMessage());
    }

    @Test
    public void TestToySupplierSupplyFails_CosProductIsNotToy() throws Exception {
        Supplier s=new ToySupplier("Games");
        when(tw.getSupplierByID(s.getID())).thenReturn(s);

        Throwable exception = assertThrows(Exception.class, () -> s.Supply(grocery,tw));

        verify(tw, times(0)).addProduct(grocery);
        assertEquals("Mi nem foglalkozunk ilyen áruval", exception.getMessage());
    }
}
