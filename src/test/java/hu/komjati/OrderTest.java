package hu.komjati;

import static org.junit.jupiter.api.Assertions.*;

import hu.komjati.customers.Customer;
import hu.komjati.orders.Order;
import hu.komjati.orders.OrderBuilder;
import hu.komjati.orders.OrderImpl;
import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class  OrderTest {

    @Mock Customer c;
    @Mock  List<Product> cart;
    @Mock Grocery g;

    @Test
    public void testOrderBuilder(){
        OrderBuilder b=new OrderBuilder();


        Order o=b.setCart(cart).setCustomer(c).createOrder();

        assertNotNull(o);
        assertInstanceOf(OrderImpl.class,o);
    }

    @Test
    public void testGetCustomer()  {
        OrderBuilder b=new OrderBuilder();
        Order o=b.setCart(cart).setCustomer(c).createOrder();

        Customer cust=o.getCustomer();

        assertEquals(c,cust);
    }

    @Test
    public void testGetOrderedProds()  {
        cart.add(g);
        OrderBuilder b=new OrderBuilder();
        Order o=b.setCart(cart).setCustomer(c).createOrder();

        List<Product> orderedProds=o.getOrderedProds();

        assertIterableEquals(cart,orderedProds);
    }

    @Test
    public void getRecordTime(){
        Date recDate=new Date();
        OrderBuilder b=new OrderBuilder();
        Order o=b.setCart(cart).setCustomer(c).createOrder();

        assertEquals(recDate,o.getRecordTime());

    }
}
