package stock.management.api_stock.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stock.management.api_stock.dto.DataStock;
import stock.management.api_stock.dto.DataStockList;
import stock.management.api_stock.dto.DataRegisterProduct;
import stock.management.api_stock.dto.DataUpdateProduct;
import stock.management.api_stock.exception.StockException;
import stock.management.api_stock.models.Product;
import stock.management.api_stock.repositories.ProductRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ProductRepository productRepository;

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
        URI uri = uriComponentsBuilder.path("/stock/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataStock(product));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataStock> updateProduct(@RequestBody DataUpdateProduct dataUpdateProduct, @PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new StockException("The id doesn't exist. Please, try it with another id.");
        }

        Product product1 = product.get();
        product1.update(dataUpdateProduct);
        productRepository.save(product1);
        return ResponseEntity.ok(new DataStock(product1));
    }


}
