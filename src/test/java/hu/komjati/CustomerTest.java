package hu.komjati;

import hu.komjati.customers.Customer;

import hu.komjati.customers.CustomerFactoryImpl;
import hu.komjati.customers.CustomerImpl;
import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.warehouses.Warehouse;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CustomerTest {
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getIDTest(){
        //given
        Customer c=mock(Customer.class);
        when(c.getID()).thenReturn(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
        //when
        UUID returnedID=c.getID();
        //then
        verify(c,times(1)).getID();
        assertEquals(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"),returnedID);

    }


    @Test
    public void getAndSetNameTest(){
        //given
        Customer c=mock(CustomerImpl.class,RETURNS_DEEP_STUBS);
        String testName="Test Name";
        when(c.getName()).thenCallRealMethod();
        doCallRealMethod().when(c).setName(anyString());

        //when
        c.setName(testName);

        //then
        verify(c,times(1)).setName(testName);
        assertEquals(testName,c.getName());
    }

    @Test
    public void getAndSetAddressTest(){
        //given
        Customer c=mock(CustomerImpl.class,RETURNS_DEEP_STUBS);
        String testAddr="Test Address 12.";
        when(c.getAddress()).thenCallRealMethod();
        doCallRealMethod().when(c).setAddress(anyString());

        //when
        c.setAddress(testAddr);

        //then
        verify(c,times(1)).setAddress(testAddr);
        assertEquals(testAddr,c.getAddress());
    }

    @Test
    public void addToCartTest(){

        //given
        Customer c=mock(CustomerImpl.class);
        Product prod=mock(Grocery.class);

        //when
        c.addToCart(prod);

        //then
        verify(c,times(1)).addToCart(prod);
    }
    @Test
    public void orderProductTest(){
        //given
        Customer c=mock(CustomerImpl.class);
        Warehouse w=mock(GroceryWarehouse.class);
        Product p=mock(Grocery.class);
        c.addToCart(p);

        //when
        try {
            c.orderProducts(w);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        try {
            verify(c,times(1)).orderProducts(w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomerFactory(){
        CustomerFactoryImpl f=  mock(CustomerFactoryImpl.class);

        doCallRealMethod().when(f).createCustomer(anyString(),anyString());
        Customer c=f.createCustomer("test","test addr");

        verify(f,times(1)).createCustomer(anyString(),anyString());
        assertTrue(c instanceof CustomerImpl);
    }

}
