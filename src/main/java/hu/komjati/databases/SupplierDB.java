package hu.komjati.databases;

import hu.komjati.suppliers.Supplier;

import java.util.List;
import java.util.UUID;

public interface SupplierDB {
    void addSupplier(Supplier s);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierByID(UUID ID);
    void deleteSupplier(UUID ID);

}
