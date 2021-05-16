package hu.komjati.products;



import java.util.UUID;

public interface Product {

 String getName();
 int getPrice();
 UUID getID();
 void setName(String name);
 void setPrice(int price);

}
