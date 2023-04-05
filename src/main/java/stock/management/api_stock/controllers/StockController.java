package stock.management.api_stock.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stock.management.api_stock.dto.DataStock;
import stock.management.api_stock.dto.DataStockList;
import stock.management.api_stock.dto.RegisterProduct;
import stock.management.api_stock.models.Stock;
import stock.management.api_stock.repositories.StockRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public ResponseEntity<List<DataStockList>> listStock() {
        List<DataStockList> list = stockRepository.findAll().stream().map(DataStockList::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataStock> registerProduct(@RequestBody RegisterProduct registerProduct, UriComponentsBuilder uriComponentsBuilder) throws Exception {

        if (stockRepository.existsByNameAndProviderAndType(registerProduct.name(), registerProduct.provider(), registerProduct.type())) {
            throw new Exception("This product is already registered, please use the update method!");
        }

        Stock stock = new Stock(registerProduct);
        stockRepository.save(stock);
        URI uri = uriComponentsBuilder.path("/stock/{id}").buildAndExpand(stock.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataStock(stock));
    }
}
