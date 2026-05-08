import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void add_shouldAddToMap_whenGivenOrder() {
        OrderListRepo or = new OrderListRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));
        List<Product> productList = new ArrayList<>(Arrays.asList(product1, product2));

        Order order1 = new Order(productList);

        or.add(order1);

        assertEquals(1, or.retrieveAll().size());
    }

    @Test
    void remove_shouldRemoveFromMap_whenGivenId() {
        OrderListRepo or = new OrderListRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));
        List<Product> productList = new ArrayList<>(Arrays.asList(product1, product2));

        Order order1 = new Order(productList);
        Order order2 = new Order(productList);

        or.add(order1);
        or.add(order2);

        or.remove(order1.id());
        assertEquals(1, or.retrieveAll().size());
    }

    @Test
    void retrieveOrder_shouldReturnOrder_whenGivenId() {
        OrderListRepo or = new OrderListRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));
        List<Product> productList = new ArrayList<>(Arrays.asList(product1, product2));

        Order order1 = new Order(productList);

        or.add(order1);


        assertEquals(order1, or.retrieveOrder(order1.id()));
    }

    @Test
    void retrieveAll_shouldReturnAllOrders_whenCalled() {
        OrderListRepo or = new OrderListRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));
        List<Product> productList = new ArrayList<>(Arrays.asList(product1, product2));

        Order order1 = new Order(productList);
        Order order2 = new Order(productList);

        or.add(order1);
        or.add(order2);


        assertEquals(2, or.retrieveAll().size());
    }
}