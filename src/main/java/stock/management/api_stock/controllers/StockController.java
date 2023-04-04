package stock.management.api_stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.management.api_stock.dto.DataStockList;
import stock.management.api_stock.models.Stock;
import stock.management.api_stock.repositories.StockRepository;

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
}
