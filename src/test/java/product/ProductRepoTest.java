package product;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepoTest {

    Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
    Product product2 = new Product("Longsword", new BigDecimal("200"));

    @Test
    public void add_shouldAddToMap_whenGivenProduct() {
        ProductRepo pr = new ProductRepo();
        pr.add(product1);

        assertEquals(1, pr.getProducts().size());
        assertEquals(1, pr.getQuantites().size());
        assertEquals(1, pr.retrieveQuantity(product1.id()));
    }

    @Test
    public void add_shouldAddMultipleProducts_whenGivenExistingProduct() {
        ProductRepo pr = new ProductRepo();
        pr.add(product1);
        pr.add(product1);

        assertEquals(1, pr.getProducts().size());
        assertEquals(1, pr.getQuantites().size());
        assertEquals(2, pr.retrieveQuantity(product1.id()));
    }

    @Test
    public void remove_shouldReduceAmount_whenGivenProductId() {
        ProductRepo pr = new ProductRepo();

        //add product
        pr.add(product1);
        pr.remove(product1.id());

        assertEquals(0, pr.retrieveQuantity(product1.id()));
    }

    @Test
    public void retrieve_shouldRetrieveFromMap_whenGivenProductId() {
        ProductRepo pr = new ProductRepo();

        //add product
        pr.add(product1);

        assertEquals(product1, pr.retrieve(product1.id()));
    }


    @Test
    public void retrieveQuantity_shouldRetrieveFromMap_whenGivenProductId() {
        ProductRepo pr = new ProductRepo();

        //add product
        pr.add(product1);

        assertEquals(1, pr.retrieveQuantity(product1.id()));
    }

    @Test
    public void retrieveAll_shouldRetrieveAllFromMap_whenCalled() {
        ProductRepo pr = new ProductRepo();
        List<Product> expected = new ArrayList<>(Arrays.asList(product1, product2));

        //add product
        pr.add(product1);
        pr.add(product2);

        assertEquals(2, pr.retrieveAll().size());
        assertTrue(pr.retrieveAll().containsAll(expected));
    }

    @Test
    public void itemCount_shouldReturnTotalCountOfProducts_whenCalled() {
        ProductRepo pr = new ProductRepo();
        Product product1 = new Product("Greatsword", new BigDecimal("250.5"));
        Product product2 = new Product("Longsword", new BigDecimal("200"));

        //add product
        pr.add(product1);
        pr.add(product2);
        pr.add(product2);

        assertEquals(3, pr.itemCount());
    }
}