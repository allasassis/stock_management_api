package stock.management.api_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.Transaction;
import stock.management.api_stock.models.Type;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
