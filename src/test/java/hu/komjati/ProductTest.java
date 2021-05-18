package hu.komjati;

import hu.komjati.products.Grocery;
import hu.komjati.products.Product;
import hu.komjati.products.Toy;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

    Product p=new Grocery("test name",1000,new Date());

    @Test
    public void testGetName(){
        String name=p.getName();

        assertEquals("test name",name);
    }

    @Test
    public void testSetName(){
        p.setName("new name");

        String name=p.getName();

        assertEquals("new name",name);
    }

    @Test
    public void getPriceTest(){

        int price=p.getPrice();

        assertEquals(1000,price);
    }

    @Test
    public void testSetPrice(){
        p.setPrice(500);

        int price=p.getPrice();

        assertEquals(500,price);
    }

    Product p1=new Toy("test toy",15000,3);

    @Test
    public void testGetToyName(){
        String name=p1.getName();

        assertEquals("test toy",name);
    }

    @Test
    public void testToySetName(){
        p1.setName("new toy name");

        String name=p1.getName();

        assertEquals("new toy name",name);
    }

    @Test
    public void getToyPriceTest(){

        int price=p1.getPrice();

        assertEquals(15000,price);
    }

    @Test
    public void testSetToyPrice(){
        p1.setPrice(12500);

        int price=p1.getPrice();

        assertEquals(12500,price);
    }
}
