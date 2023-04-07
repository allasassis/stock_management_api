package stock.management.api_stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.management.api_stock.models.Transaction;
import stock.management.api_stock.models.TransactionType;
import stock.management.api_stock.models.User;
import stock.management.api_stock.repositories.TransactionRepository;

import java.time.LocalDateTime;

@Service
public class CreateTransaction {

    @Autowired
    private TransactionRepository repository;

    public void create(TransactionType transactionType) {

        Transaction transaction = new Transaction(null, LocalDateTime.now(), transactionType);
        repository.save(transaction);
    }
}
