package product;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(UUID id, String name, BigDecimal price) {
    public Product(String name, BigDecimal price) {
        this(UUID.randomUUID(), name, price);
    }
}
