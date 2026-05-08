import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepoTest {

    @Test
    public void add_shouldAddToMap_whenGivenProduct() {
        ProductRepo pr = new ProductRepo();
        Product product = new Product("Greatsword", new BigDecimal("250.5"));
        pr.add(product);

        assertEquals(1, pr.getProducts().size());
    }

    @Test
    public void remove_shouldRemoveFromMap_whenGivenProductId() {
        ProductRepo pr = new ProductRepo();
        Product product = new Product("Greatsword", new BigDecimal("250.5"));

        //add product
        pr.add(product);
        pr.remove(product.id());

        assertEquals(0, pr.getProducts().size());
    }

    @Test
    public void retrieve_shouldRetrieveFromMap_whenGivenProductId() {
        ProductRepo pr = new ProductRepo();
        Product product = new Product("Greatsword", new BigDecimal("250.5"));

        //add product
        pr.add(product);

        assertEquals(product, pr.retrieve(product.id()));
    }

    @Test
    public void retrieveAll_shouldRetrieveAllFromMap_whenCalled() {
        ProductRepo pr = new ProductRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));
        List<Product> expected = new ArrayList<>(Arrays.asList(product1, product2));

        //add product
        pr.add(product1);
        pr.add(product2);

        assertEquals(2, pr.retrieveAll().size());
        assertTrue(pr.retrieveAll().containsAll(expected));
    }
}