package stock.management.api_stock.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.management.api_stock.dto.DataTransactionsList;
import stock.management.api_stock.repositories.TransactionRepository;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@SecurityRequirement(name = "bearer-key")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public ResponseEntity<List<DataTransactionsList>> listTransactions() {
        List<DataTransactionsList> list = repository.findAll().stream().map(DataTransactionsList::new).toList();

        return ResponseEntity.ok(list);
    }
}
