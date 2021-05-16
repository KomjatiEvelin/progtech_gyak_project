package hu.komjati;

import hu.komjati.customers.Customer;
import hu.komjati.orders.Order;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class OrderTest {
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getIDTest(){
        //given
        Order o=mock(Order.class);
        when(o.getID()).thenReturn(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
        //when
        UUID returnedID=o.getID();
        //then
        verify(o,times(1)).getID();
        assertEquals(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"),returnedID);

    }

    @Test
    public void getCustomerTest(){
        //given
        Order o=mock(Order.class);
        Customer c=mock(Customer.class);
        when(o.getCustomer()).thenReturn(c);
        //when
        Customer joinedCustomer=o.getCustomer();
        //then
        verify(o,times(1)).getCustomer();
        assertEquals(c,joinedCustomer);

    }



}
