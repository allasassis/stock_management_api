package stock.management.api_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.management.api_stock.models.Stock;
import stock.management.api_stock.models.Type;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Boolean existsByNameAndProviderAndType(String name, String provider, Type type);

    Stock findByNameAndProviderAndType(String name, String provider, Type type);
}
