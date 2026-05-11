import order.OrderListRepo;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductRepo;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
    Product product2 = new Product("Longsword", new BigDecimal("200"));

    @Test
    void placeOrder_returnNull_whenProductNotFound() {
        UUID[] productIds = {product2.id()};
        ProductRepo pr = new ProductRepo();
        OrderListRepo or = new OrderListRepo();

        pr.add(product1);
        ShopService shopService = new ShopService(pr, or);

        assertNull(shopService.placeOrder(productIds));

    }

    @Test
    void placeOrder_returnOrderWithCorrectProduct_whenProductsFound() {
        UUID[] productIds = {product2.id()};
        ProductRepo pr = new ProductRepo();
        OrderListRepo or = new OrderListRepo();

        pr.add(product1);
        pr.add(product2);
        ShopService shopService = new ShopService(pr, or);

        assertTrue(shopService.placeOrder(productIds).products().contains(product2));

    }
}