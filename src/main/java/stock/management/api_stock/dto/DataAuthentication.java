package stock.management.api_stock.dto;

import jakarta.validation.constraints.NotNull;

public record DataAuthentication(@NotNull String username, @NotNull String password) {
}
