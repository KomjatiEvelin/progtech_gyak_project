package hu.komjati.databases.memoryDBs;

import hu.komjati.databases.OrderDB;
import hu.komjati.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryOrderDB implements OrderDB {

    private List<Order> orders;

    public MemoryOrderDB() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void recordNewOrder(Order o) {

        this.orders.add(o);

    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> temp=new ArrayList<>();
        for (Order o:orders) {
            temp.add(o);
        }
        return temp;
    }

    @Override
    public Order getOrderByID(UUID ID) {
        for (Order o:orders) {
            if(o.getID()==ID){
                return o;
            }
        }
        return null;
    }

    @Override
    public void deleteOrder(UUID ID) {
        for (Order o:orders) {
            if (o.getID() == ID) {
                orders.remove(o) ;
                break;
            }
        }
    }
}
