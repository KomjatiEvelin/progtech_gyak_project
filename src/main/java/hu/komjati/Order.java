package hu.komjati;

import hu.komjati.interfaces.Customer;
import hu.komjati.interfaces.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private Customer customer;
    private List<Product> orderedProds;
    private UUID ID;
    private Date recordTime;

    public Order(Customer customer, List<Product> cart) {
        this.ID=UUID.randomUUID();
        this.customer=customer;
        this.orderedProds=cart;
        this.recordTime=new Date();
    }

    public UUID getID(){
        return this.ID;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public List<Product> getPrdoucts(){
        return this.orderedProds;
    }

    public  Date getRecordTime(){
        return this.recordTime;
    }

    @Override
    public String toString() {
        String text="";
        text+="\n-----ORDERED--------\n"+this.ID+":"+this.customer.toString()+" -----\n";
        for (Product p:orderedProds) {
            text+="\n"+p.toString();
        }
        text+="\n-----"+this.recordTime+"--------";
        return text;
    }
}
