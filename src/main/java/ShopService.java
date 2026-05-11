import order.Order;
import order.OrderListRepo;
import order.OrderMapRepo;
import product.Product;
import product.ProductRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderMapRepo orderRepo;


    public ShopService(ProductRepo productRepo, OrderMapRepo orderMapRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderMapRepo;
    }


    public Order placeOrder(UUID[] ids) {
        List<Product> productList = new ArrayList<>();
        for (UUID id : ids) {
            Product found = this.productRepo.retrieve(id);
            int foundQuantity = this.productRepo.retrieveQuantity(id);
            if (found == null || foundQuantity <= 0) {
                return null;
            }
            productList.add(found);
        }

        Order order = new Order(productList);
        this.orderRepo.add(order);
        return order;
    }

    public BigDecimal totalSum(UUID orderId) {
        Order order = this.orderRepo.retrieveOrder(orderId);
        BigDecimal sum = new BigDecimal(0);
        for (Product product : order.products()) {
            sum = sum.add(product.price());
        }

        return sum;
    }

    public Order changeOrder(UUID oldOrderId, UUID[] newProductIds) {
        Order newOrder = placeOrder(newProductIds);
        if (newOrder != null) {
            orderRepo.remove(oldOrderId);
            return newOrder;
        }
        return null;
    }

    public void listProduct() {
        List<Product> products = productRepo.retrieveAll();
        int totalQuantity = productRepo.itemCount();
        System.out.printf("%d type(s) of items. total quantity: %d items\n", products.size(), totalQuantity);
        for (Product product : products) {
            int quantity = productRepo.retrieveQuantity(product.id());
            System.out.printf("- %s, price: %s, quantity: %d (%s)\n", product.name(), product.price(), quantity,
                    product.id());
        }
    }
}
