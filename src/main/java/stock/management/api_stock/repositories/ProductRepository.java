package stock.management.api_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.Type;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Boolean existsByNameAndProviderAndType(String name, String provider, Type type);
}
