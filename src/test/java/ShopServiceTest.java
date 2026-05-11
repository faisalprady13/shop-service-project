import order.Order;
import order.OrderMapRepo;
import order.OrderMapRepo;
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
        OrderMapRepo or = new OrderMapRepo();

        pr.add(product1);
        ShopService shopService = new ShopService(pr, or);

        assertNull(shopService.placeOrder(productIds));

    }

    @Test
    void placeOrder_returnOrderWithCorrectProduct_whenProductsFound() {
        UUID[] productIds = {product2.id()};
        ProductRepo pr = new ProductRepo();
        OrderMapRepo or = new OrderMapRepo();

        pr.add(product1);
        pr.add(product2);
        ShopService shopService = new ShopService(pr, or);

        assertTrue(shopService.placeOrder(productIds).products().contains(product2));
    }

    @Test
    void totalSum_shouldReturnSum_whenGivenOrderId() {

        UUID[] productIds = {product1.id(), product1.id(), product2.id()};
        ProductRepo pr = new ProductRepo();
        OrderMapRepo or = new OrderMapRepo();

        pr.add(product1);
        pr.add(product2);

        ShopService shopService = new ShopService(pr, or);
        Order order = shopService.placeOrder(productIds);

        assertEquals(new BigDecimal("701.0"), shopService.totalSum(order.id()));
    }

    @Test
    void changeOrder_shouldReplaceOrder_whenGivenOrderIdAndProductList() {
        UUID[] productIds1 = {product1.id(), product1.id(), product2.id()};
        UUID[] productIds2 = {product1.id(),};
        ProductRepo pr = new ProductRepo();
        OrderMapRepo or = new OrderMapRepo();

        pr.add(product1);
        pr.add(product2);

        ShopService shopService = new ShopService(pr, or);
        Order order = shopService.placeOrder(productIds1);

        Order newOrder = shopService.changeOrder(order.id(), productIds2);

        assertFalse(newOrder.products().contains(product2));
        assertNull(or.retrieveOrder(order.id()));
    }
}