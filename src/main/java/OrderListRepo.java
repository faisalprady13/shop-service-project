import java.util.*;

public class OrderListRepo {
    private final Map<UUID, Order> orders = new HashMap<>();

    public void add(Order order) {
        orders.put(order.id(), order);
    }

    public void remove(UUID id) {
        this.orders.remove(id);
    }

    public Order retrieveOrder(UUID id) {
        return this.orders.get(id);
    }

    public List<Order> retrieveAll() {
        return new ArrayList<>(this.orders.values());
    }
}
