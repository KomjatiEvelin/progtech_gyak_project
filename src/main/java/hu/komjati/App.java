package hu.komjati;

import hu.komjati.customers.CustomerFactory;
import hu.komjati.customers.CustomerFactoryImpl;
import hu.komjati.databases.*;
import hu.komjati.databases.memoryDBs.MemoryCustomerDB;
import hu.komjati.databases.memoryDBs.MemoryOrderDB;
import hu.komjati.databases.memoryDBs.MemoryProductDB;
import hu.komjati.databases.memoryDBs.MemorySuppliersDB;
import hu.komjati.products.*;
import hu.komjati.suppliers.GrocerySupplier;
import hu.komjati.suppliers.ToySupplier;
import hu.komjati.warehouses.GroceryWarehouse;
import hu.komjati.customers.Customer;
import hu.komjati.suppliers.Supplier;
import hu.komjati.warehouses.ToyWarehouse;
import hu.komjati.warehouses.Warehouse;

import java.util.Date;
import java.util.List;

public class  App
{

    public static void main( String[] args )
    {
        CustomerFactory customerFactory= CustomerFactoryImpl.getInstance();
        CustomerDB GWcustomers=new MemoryCustomerDB();
        ProductDB GWproducts=new MemoryProductDB();
        SupplierDB GWsuppliers=new MemorySuppliersDB();
        OrderDB GWorders=new MemoryOrderDB();

        CustomerDB TWcustomers=new MemoryCustomerDB();
        ProductDB TWproducts=new MemoryProductDB();
        SupplierDB TWsuppliers=new MemorySuppliersDB();
        OrderDB TWorders=new MemoryOrderDB();

        Warehouse w=GroceryWarehouse.getInstance(GWcustomers,GWproducts,GWsuppliers,GWorders);
        Warehouse tw= ToyWarehouse.getInstance(TWcustomers,TWproducts,TWsuppliers,TWorders);

        Supplier gs=new GrocerySupplier("Goods");
        Supplier ts=new ToySupplier("Games");

        try {
            w.addSupplier(gs);
            tw.addSupplier(ts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            for (int i=0;i<10;i++){

                gs.Supply (new Grocery("prod"+i,100*i,new Date()),w);
                ts.Supply(new Toy("toy"+i,50*i,i*2),tw);
            }
            gs.Supply(new Toy("toy1",300,1),w);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        ListaKiir(w.getProductsList());

        Customer c= customerFactory.createCustomer("Próba János","1234 Teszfalva, Próba út 19.");


        w.addCustomer(c);

        System.out.println(w.getCustomerByID(c.getID()).toString());

        System.out.println();

        ListaKiir(tw.getProductsList());
    }

    static void ListaKiir(List l){
        for (Object o:l) {
            System.out.println(o.toString());
        }
    }

}
