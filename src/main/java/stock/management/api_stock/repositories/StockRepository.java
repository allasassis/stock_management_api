package stock.management.api_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.management.api_stock.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
