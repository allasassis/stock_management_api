package stock.management.api_stock.dto;

import jakarta.validation.constraints.NotNull;
import stock.management.api_stock.models.Type;

public record DataUpdateProduct(@NotNull String username, String name, String description, String provider, Type type) {
}
