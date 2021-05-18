package hu.komjati;

import hu.komjati.databases.memoryDBs.MemoryCustomerDB;
import hu.komjati.databases.memoryDBs.MemoryOrderDB;
import hu.komjati.databases.memoryDBs.MemoryProductDB;
import hu.komjati.databases.memoryDBs.MemorySuppliersDB;
import hu.komjati.products.Grocery;
import hu.komjati.products.Toy;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class WarehouseTest {


    MemoryCustomerDB customerDB=new MemoryCustomerDB();

    MemoryProductDB memoryProductDB=new MemoryProductDB();

    MemorySuppliersDB suppliersDB=new MemorySuppliersDB();

    MemoryOrderDB orderDB= new MemoryOrderDB();

    @Mock
    Grocery grocery;
    @Mock
    Toy toy;

    Warehouse groceryWH= GroceryWarehouse.getInstance(customerDB,memoryProductDB,suppliersDB,orderDB);

    @Test
    public void addProductToGroceryWarehouseSuccessfullyTest() throws Exception {
        groceryWH.addProduct(grocery);

    }
    @Test
    public void addProductToGroceryWarehouseThrowException() throws Exception {


        Throwable exception = assertThrows(Exception.class, () -> groceryWH.addProduct(toy));
        assertEquals("Ilyen áruval nem foglalkozunk", exception.getMessage());

    }
}
