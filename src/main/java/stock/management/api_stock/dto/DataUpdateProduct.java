package stock.management.api_stock.dto;

import jakarta.validation.constraints.NotNull;
import stock.management.api_stock.models.Type;

public record DataUpdateProduct(String name, String description, String provider, Integer quantity, Type type) {
}
