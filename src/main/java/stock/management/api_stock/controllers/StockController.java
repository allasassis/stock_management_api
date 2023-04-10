package stock.management.api_stock.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stock.management.api_stock.dto.*;
import stock.management.api_stock.exception.StockException;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.models.TransactionType;
import stock.management.api_stock.repositories.ProductRepository;
import stock.management.api_stock.validators.ValidatorProductExist;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ValidatorProductExist validator;

    @Autowired
    private CreateTransaction createTransaction;

    @GetMapping
    public ResponseEntity<List<DataStockList>> listStock() {
        List<DataStockList> list = productRepository.findAll().stream().map(DataStockList::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataStock> registerProduct(@RequestBody DataRegisterProduct productDto, UriComponentsBuilder uriComponentsBuilder) {

        if (productRepository.existsByNameAndProviderAndType(productDto.name(), productDto.provider(), productDto.type())) {
            throw new StockException("This product is already registered, please use the update method!");
        }

        Product product = new Product(productDto);
        productRepository.save(product);

        // Creating transaction
        createTransaction.create(productDto.username(), TransactionType.REGISTER_PRODUCT);

        URI uri = uriComponentsBuilder.path("/stock/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataStock(product));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataStock> updateProduct(@RequestBody DataUpdateProduct dataUpdateProduct, @PathVariable Long id) {
        Product product = validator.valid(id);
        product.update(dataUpdateProduct);
        productRepository.save(product);

        createTransaction.create(dataUpdateProduct.username(), TransactionType.UPDATE_PRODUCT);

        return ResponseEntity.ok(new DataStock(product));
    }

    @PutMapping("/quantity/{id}")
    @Transactional
    public ResponseEntity<DataStock> updateQuantityProduct(@RequestBody DataUpdateQuantity dataUpdateQuantity, @PathVariable Long id) {
        Product product = validator.valid(id);
        product.updateQuantity(dataUpdateQuantity);
        productRepository.save(product);

        createTransaction.create(dataUpdateQuantity.username(), TransactionType.UPDATE_QUANTITY_PRODUCT);

        return ResponseEntity.ok(new DataStock(product));
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id, @PathVariable String username) {
        Product product = validator.valid(id);
        productRepository.delete(product);

        createTransaction.create(username, TransactionType.DELETE_PRODUCT);

        return ResponseEntity.noContent().build();
    }

}
