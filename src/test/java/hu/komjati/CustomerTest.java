package hu.komjati;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import hu.komjati.customers.Customer;
import hu.komjati.customers.CustomerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @Test
    public void testGetName()  {
        Customer c=new CustomerImpl("Test Name","1234 Test Adress 12.");

        assertEquals("Test Name",c.getName());
    }

    @Test
    public void testSetName(){
        Customer c=new CustomerImpl("Test Name","1234 Test Adress 12.");
        c.setName("New Test Name");

        assertEquals("New Test Name",c.getName());
    }
}
