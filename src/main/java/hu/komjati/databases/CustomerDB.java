package hu.komjati.databases;

import hu.komjati.customers.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDB {
    void addCustomer(Customer c);
    List<Customer> getAllCustomers();
    Customer getCustomerByID(UUID ID);
    void deleteCustomer(UUID ID);

}
