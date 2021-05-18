package hu.komjati.databases.memoryDBs;

import hu.komjati.databases.ProductDB;
import hu.komjati.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryProductDB implements ProductDB {

    private List<Product> products;

    public MemoryProductDB() {
        this.products = new ArrayList<>();
    }


    @Override
    public void addProduct(Product p) {
        if(!products.contains(p)){
            this.products.add(p);

        }
    }

    @Override
    public List<Product> getProductsList() {
        List<Product> temp=new ArrayList<>();
        for (Product p:products) {
            temp.add(p);
        }
        return temp;
    }

    @Override
    public Product getProductByID(UUID ID) {
        for (Product p:products) {
            if(p.getID()==ID){
                return p;
            }
        }
        return null;

    }

    @Override
    public void deleteProduct(UUID ID) {
        for (Product p:products) {
            if (p.getID() == ID) {
               products.remove(p) ;
               break;
            }
        }
    }
}
