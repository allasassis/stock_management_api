package stock.management.api_stock.dto;

import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.Type;

public record DataStock(String name, String description, String provider, int quantity, Type type) {

    public DataStock(Product product) {
        this(product.getName(), product.getDescription(), product.getProvider(), product.getQuantity(), product.getType());
    }
}
