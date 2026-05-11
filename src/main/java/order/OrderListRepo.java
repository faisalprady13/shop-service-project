package order;

import java.util.*;

public class OrderListRepo implements OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void remove(UUID id) {
        this.orders.removeIf(order -> order.id() == id);
//        for (Order order : this.orders) {
//            if (order.id() == id) {
//                this.orders.remove(order);
//            }
//        }
    }

    public Order retrieveOrder(UUID id) {
        for (Order order : this.orders) {
            if (order.id() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> retrieveAll() {
        return this.orders;
    }
}
