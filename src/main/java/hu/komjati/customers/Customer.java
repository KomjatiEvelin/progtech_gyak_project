package hu.komjati.customers;

import hu.komjati.products.Product;
import hu.komjati.warehouses.Warehouse;

import java.util.UUID;

public interface Customer {
  UUID getID();
  String getName();
  void setName(String name);
  String getAddress();
  void setAddress(String address);
  void orderProducts(Warehouse w);
  void addToCart(Product p);

}
