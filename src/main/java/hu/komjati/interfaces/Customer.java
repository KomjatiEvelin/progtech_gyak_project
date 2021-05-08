package hu.komjati.interfaces;

import java.util.List;
import java.util.UUID;

public interface Customer {
  UUID getID();
  String getName();
  void setName(String name);
  String getAddress();
  void setAddress(String address);
  void orderProducts(List<Product> p, Warehouse w);
  void addToCart(Product p);

}
