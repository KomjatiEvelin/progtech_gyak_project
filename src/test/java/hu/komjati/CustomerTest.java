package hu.komjati;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import hu.komjati.customers.Customer;
import hu.komjati.customers.CustomerFactory;
import hu.komjati.customers.CustomerFactoryImpl;
import hu.komjati.customers.CustomerImpl;
import hu.komjati.databases.memoryDBs.MemoryCustomerDB;
import hu.komjati.databases.memoryDBs.MemoryOrderDB;
import hu.komjati.databases.memoryDBs.MemoryProductDB;
import hu.komjati.databases.memoryDBs.MemorySuppliersDB;
import hu.komjati.orders.OrderImpl;
import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.products.Toy;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.ToyWarehouse;
import hu.komjati.warehouses.Warehouse;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @Mock Grocery g;
    @Mock Toy t;
    @Mock MemoryCustomerDB cdb;
    @Mock MemoryOrderDB odb;
    @Mock MemoryProductDB pdb;
    @Mock MemorySuppliersDB sdb;

    @Test
    public void testCreateCustomer(){
        CustomerFactory f= CustomerFactoryImpl.getInstance();
        Customer c=f.createCustomer("Test Name","1234 Test Address 12.");

        assertInstanceOf(CustomerImpl.class,c);
    }
    @Test
    public void testGetName()  {
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");

        assertEquals("Test Name",c.getName());
    }

    @Test
    public void testGetAddress()  {
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");

        assertEquals("1234 Test Address 12.",c.getAddress());
    }

    @Test
    public void testSetName(){
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        c.setName("New Test Name");

        assertEquals("New Test Name",c.getName());
    }

    @Test
    public void testSetAddress(){
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        c.setAddress("New Test Address");

        assertEquals("New Test Address",c.getAddress());
    }

    @Test
    public void getProductsFromEmptyCart(){
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        List<Product> prodsInCart=c.getProdutsInCart();
        assertTrue(prodsInCart.isEmpty());
    }

    @Test
    public void addProductToCart_And_GetProductsFromNotEmptyCart(){
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        c.addToCart(g);
        List<Product> prodsInCart=c.getProdutsInCart();

        assertEquals(g,prodsInCart.get(0));

    }


    @Test
    public void orderProduct() throws Exception {
        Warehouse w=GroceryWarehouse.getInstance(cdb,pdb,sdb,odb);
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        List<Customer> customers=new ArrayList<>();
        List<Product> products=new ArrayList<>();
        customers.add(c);
        products.add(g);
        when(cdb.getAllCustomers()).thenReturn(customers);
        when(pdb.getProductsList()).thenReturn(products);
        w.addCustomer(c);
        w.addProduct(g);
        c.addToCart(g);

        c.orderProducts(w);

    }

    @Test
    public void orderProductFail() throws Exception {
        Warehouse w=ToyWarehouse.getInstance(cdb,pdb,sdb,odb);
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");
        List<Customer> customers=new ArrayList<>();
        List<Product> products=new ArrayList<>();
        customers.add(c);
        products.add(t);
        when(cdb.getAllCustomers()).thenReturn(customers);
        when(pdb.getProductsList()).thenReturn(products);
        w.addCustomer(c);
        w.addProduct(t);
        c.addToCart(g);



        Throwable exception = assertThrows(Exception.class, () ->   c.orderProducts(w));
        assertEquals("Ezek a termékek nem kaphatóak", exception.getMessage());

    }

    @Test
    public void orderProductFailOnUnregisteredUser() throws Exception {
        Warehouse w=ToyWarehouse.getInstance(cdb,pdb,sdb,odb);
        Customer c=new CustomerImpl("Test Name","1234 Test Address 12.");

        c.addToCart(t);


        Throwable exception = assertThrows(Exception.class, () ->   c.orderProducts(w));
        assertEquals("Nincs ilyen felhasználó nálunk", exception.getMessage());

    }
}
