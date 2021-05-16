package hu.komjati.databases.memoryDBs;

import hu.komjati.databases.OrderDB;
import hu.komjati.orders.OrderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryOrderDB implements OrderDB {

    private List<OrderImpl> orders;

    public MemoryOrderDB() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void recordNewOrder(OrderImpl o) {

        this.orders.add(o);

    }

    @Override
    public List<OrderImpl> getAllOrder() {
        List<OrderImpl> temp=new ArrayList<>();
        for (OrderImpl o:orders) {
            temp.add(o);
        }
        return temp;
    }

    @Override
    public OrderImpl getOrderByID(UUID ID) {
        for (OrderImpl o:orders) {
            if(o.getID()==ID){
                return o;
            }
        }
        return null;
    }

    @Override
    public void deleteOrder(UUID ID) {
        //TODO
    }
}
