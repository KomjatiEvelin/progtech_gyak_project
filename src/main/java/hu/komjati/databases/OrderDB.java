package hu.komjati.databases;

import hu.komjati.orders.Order;

import java.util.List;
import java.util.UUID;

public interface OrderDB {

    void recordNewOrder(Order o);
    List<Order> getAllOrder();
    Order getOrderByID(UUID ID);
    void deleteOrder(UUID ID);
}
