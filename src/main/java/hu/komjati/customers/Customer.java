package hu.komjati.customers;

import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;

import java.util.List;
import java.util.UUID;

public interface Customer {
  UUID getID();
  String getName();
  void setName(String name);
  String getAddress();
  void setAddress(String address);
  void orderProducts(Warehouse w) throws Exception;
  void addToCart(Product p);
  List<Product> getProdutsInCart();

}
