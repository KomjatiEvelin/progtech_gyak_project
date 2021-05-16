package hu.komjati.databases;

import hu.komjati.orders.OrderImpl;

import java.util.List;
import java.util.UUID;

public interface OrderDB {

    void recordNewOrder(OrderImpl o);
    List<OrderImpl> getAllOrder();
    OrderImpl getOrderByID(UUID ID);
    void deleteOrder(UUID ID);
}
