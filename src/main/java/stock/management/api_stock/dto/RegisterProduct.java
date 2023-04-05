package stock.management.api_stock.dto;

import jakarta.validation.constraints.NotNull;
import stock.management.api_stock.models.Type;

public record RegisterProduct(@NotNull String name, @NotNull String description, @NotNull String provider, @NotNull int quantity, @NotNull Type type) {
}
