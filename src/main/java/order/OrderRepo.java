package order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrderRepo {
    void add(Order order);

    void remove(UUID id);

    Order retrieveOrder(UUID id);

    List<Order> retrieveAll();
}
