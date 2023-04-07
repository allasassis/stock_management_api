package stock.management.api_stock.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import stock.management.api_stock.exception.StockException;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ValidatorProductExist {

    @Autowired
    private ProductRepository productRepository;

    // Verify if the product exist
    public Product valid(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new StockException("The id doesn't exist. Please, try it with another id.");
        }

        return product.get();
    }
}
