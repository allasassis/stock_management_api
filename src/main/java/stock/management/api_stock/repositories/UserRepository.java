package stock.management.api_stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.Type;
import stock.management.api_stock.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);
}
