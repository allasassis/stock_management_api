package stock.management.api_stock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import stock.management.api_stock.models.Transaction;
import stock.management.api_stock.models.TransactionType;
import stock.management.api_stock.models.User;

import java.time.LocalDateTime;

public record DataTransactionsList(String username, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dateTime, TransactionType transactionType) {

    public DataTransactionsList(Transaction transaction) {
        this(transaction.getUser().getUsername(), transaction.getDateTime(), transaction.getTransactionType());
    }
}
