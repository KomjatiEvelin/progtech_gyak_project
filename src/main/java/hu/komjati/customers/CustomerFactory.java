package hu.komjati.customers;

public interface CustomerFactory {
    Customer createCustomer(String name, String address);
}
