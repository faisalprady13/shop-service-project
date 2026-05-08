import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.UUID;

public class ProductRepo {
    private final Map<UUID, Product> products = new HashMap<>();

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        Product found = this.retrieve(product.id());
        if (found == null) {
            products.put(product.id(), product);
        } else {

        }
    }

    public void remove(UUID id) {
        products.remove(id);
    }

    public Product retrieve(UUID id) {
        return products.get(id);
    }

    public List<Product> retrieveAll() {
        return new ArrayList<>(this.products.values());
    }
}
