package hu.komjati;

public class CustomerImplBuilder {
    private String name;
    private String address;

    public CustomerImplBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerImplBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerImpl createCustomerImpl() {
        return new CustomerImpl(name, address);
    }
}