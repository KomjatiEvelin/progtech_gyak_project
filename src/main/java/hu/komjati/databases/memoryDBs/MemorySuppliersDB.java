package hu.komjati.databases.memoryDBs;

import hu.komjati.databases.SupplierDB;
import hu.komjati.products.Product;
import hu.komjati.suppliers.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemorySuppliersDB implements SupplierDB {
    private List<Supplier> suppliers;

    public MemorySuppliersDB() {
        this.suppliers = new ArrayList<>();
    }

    @Override
    public void addSupplier(Supplier s) {
        if(!suppliers.contains(s)){
            this.suppliers.add(s);

        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> temp=new ArrayList<>();
        for (Supplier s:suppliers) {
            temp.add(s);
        }
        return temp;
    }

    @Override
    public Supplier getSupplierByID(UUID ID) {
        for (Supplier s:suppliers) {
            if(s.getID()==ID){
                return s;
            }
        }
        return null;
    }

    @Override
    public void deleteSupplier(UUID ID) {
        for (Supplier s:suppliers) {
            if (s.getID() == ID) {
                suppliers.remove(s) ;
                break;
            }
        }
    }
}
