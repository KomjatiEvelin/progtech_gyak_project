package hu.komjati.customers;

public class CustomerFactory {

    private static CustomerFactory customerFactory=null;
    private CustomerFactory() {
    }

    public static CustomerFactory getInstance(){
        if(customerFactory==null){
            customerFactory=new CustomerFactory();
        }
        return customerFactory;
    }

    public Customer createCustomer(String name, String address){
        return new CustomerImpl(name,address);
    }
}
