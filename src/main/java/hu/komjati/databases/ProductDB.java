package hu.komjati.databases;

import hu.komjati.products.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDB {
    void addProduct(Product p);
    List<Product> getProductsList();
    Product getProductByID(UUID ID);
    void deleteProduct(UUID ID);
}
