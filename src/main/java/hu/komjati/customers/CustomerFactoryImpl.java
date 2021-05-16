package hu.komjati.customers;

public class CustomerFactoryImpl implements  CustomerFactory{

    private static CustomerFactoryImpl customerFactory=null;
    private CustomerFactoryImpl() {
    }

    public static CustomerFactoryImpl getInstance(){
        if(customerFactory==null){
            customerFactory=new CustomerFactoryImpl();
        }
        return customerFactory;
    }

    public Customer createCustomer(String name, String address){
        return new CustomerImpl(name,address);
    }
}
