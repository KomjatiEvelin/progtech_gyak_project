package hu.komjati;

import hu.komjati.databases.memoryDBs.MemoryCustomerDB;
import hu.komjati.databases.memoryDBs.MemoryOrderDB;
import hu.komjati.databases.memoryDBs.MemoryProductDB;
import hu.komjati.databases.memoryDBs.MemorySuppliersDB;
import hu.komjati.products.Grocery;
import hu.komjati.products.Toy;
import hu.komjati.suppliers.GrocerySupplier;
import hu.komjati.suppliers.ToySupplier;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.ToyWarehouse;
import hu.komjati.warehouses.Warehouse;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


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
    @Mock
    GrocerySupplier gsup;
    @Mock
    ToySupplier tsup;


    Warehouse groceryWH= GroceryWarehouse.getInstance(customerDB,memoryProductDB,suppliersDB,orderDB);
    Warehouse toyWH= ToyWarehouse.getInstance(customerDB,memoryProductDB,suppliersDB,orderDB);


    @Test
    public void addProductToGroceryWarehouseSuccessfullyTest() throws Exception {
        groceryWH.addProduct(grocery);

    }
    @Test
    public void addProductToGroceryWarehouseThrowException() {


        Throwable exception = assertThrows(Exception.class, () -> groceryWH.addProduct(toy));
        assertEquals("This product type is not our profile", exception.getMessage());

    }

    @Test
    public void addSupplierToGroceryWarehouseSuccessfullyTest() throws Exception {
        groceryWH.addSupplier(gsup);
    }

    @Test
    public void addSupplierToGroceryWarehouseThrowException() {


        Throwable exception = assertThrows(Exception.class, () -> groceryWH.addSupplier(tsup));
        assertEquals("We only work with  GrocerySuppliers", exception.getMessage());

    }


    @Test
    public void addProductToToyWarehouseSuccessfullyTest() throws Exception {
        toyWH.addProduct(toy);

    }
    @Test
    public void addProductToToyWarehouseThrowException()  {


        Throwable exception = assertThrows(Exception.class, () -> toyWH.addProduct(grocery));
        assertEquals("This product type is not our profile", exception.getMessage());

    }

    @Test
    public void addSupplierToToyWarehouseSuccessfullyTest() throws Exception {
        toyWH.addSupplier(tsup);
    }

    @Test
    public void addSupplierToToyWarehouseThrowException() {

        Throwable exception = assertThrows(Exception.class, () ->  toyWH.addSupplier(gsup));
        assertEquals("We only work with  ToySuppliers", exception.getMessage());

    }



}
