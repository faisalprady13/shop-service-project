package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.UUID;

public class ProductRepo {
    private final Map<UUID, Product> products = new HashMap<>();


    private final Map<UUID, Integer> quantites = new HashMap<>();

    public Map<UUID, Integer> getQuantites() {
        return quantites;
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        Product found = products.get(product.id());

        if (found == null) {
            products.put(product.id(), product);
            quantites.put(product.id(), 1);
        } else {
            int quantity = retrieveQuantity(product.id());
            quantites.put(product.id(), quantity + 1);
        }
    }

    public void remove(UUID id) {
        int quantity = this.retrieveQuantity(id);

        if (quantity > 0) {
            quantites.put(id, quantity - 1);
        } else {
            this.quantites.remove(id);
            this.products.remove(id);
        }
    }

    public Product retrieve(UUID id) {
        Product found = products.get(id);
        if (found != null) {
            return found;
        } else {
            System.out.printf("item with id %s is not exist\n", id);
            return null;
        }
    }

    public int retrieveQuantity(UUID id) {
        return quantites.get(id) != null ? quantites.get(id) : 0;
    }

    public List<Product> retrieveAll() {
        return new ArrayList<>(this.products.values());
    }


    public int itemCount() {
        int sum = 0;
        for (int val : this.quantites.values()) {
            sum += val;
        }
        return sum;
    }
}
