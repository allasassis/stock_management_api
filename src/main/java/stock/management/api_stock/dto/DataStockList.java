package stock.management.api_stock.dto;

import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.Type;

public record DataStockList(String name, String description, String provider, int quantity, Type type) {
    public DataStockList(Product stock) {
        this(stock.getName(), stock.getDescription(), stock.getProvider(), stock.getQuantity(), stock.getType());
    }
}
