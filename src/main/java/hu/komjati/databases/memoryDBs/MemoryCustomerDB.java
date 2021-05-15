package hu.komjati.databases.memoryDBs;

import hu.komjati.customers.Customer;
import hu.komjati.databases.CustomerDB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryCustomerDB implements CustomerDB {
    private List<Customer> customers;

    public MemoryCustomerDB() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer c) {
        this.customers.add(c);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> temp=new ArrayList<>();
        for (Customer c:customers) {
            temp.add(c);
        }
        return temp;
    }

    @Override
    public Customer getCustomerByID(UUID ID) {
        for (Customer c:customers) {
            if(c.getID()==ID){
                return c;
            }
        }
        return null;
    }

    @Override
    public void deleteCustomer(UUID ID) {
        //TODO
    }
}
