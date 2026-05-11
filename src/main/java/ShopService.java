import order.Order;
import order.OrderListRepo;
import product.Product;
import product.ProductRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderListRepo orderRepo;


    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderListRepo;
    }


    public Order placeOrder(UUID[] ids) {
        List<Product> productList = new ArrayList<>();
        for (UUID id : ids) {
            Product found = this.productRepo.retrieve(id);
            if (found == null) {
                return null;
            }
            productList.add(found);
        }

        Order order = new Order(productList);
        this.orderRepo.add(order);
        return order;
    }
}
