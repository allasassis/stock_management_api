package stock.management.api_stock.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DataUpdateQuantity(@NotNull String username, @NotNull Integer quantity) {
}
