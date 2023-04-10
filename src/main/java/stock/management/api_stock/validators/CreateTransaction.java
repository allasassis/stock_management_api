package stock.management.api_stock.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import stock.management.api_stock.models.Transaction;
import stock.management.api_stock.models.TransactionType;
import stock.management.api_stock.models.User;
import stock.management.api_stock.repositories.TransactionRepository;
import stock.management.api_stock.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
public class CreateTransaction {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void create(String username, TransactionType transactionType) {

        User user =  userRepository.findByUsername(username);

        Transaction transaction = new Transaction(user, LocalDateTime.now(), transactionType);
        repository.save(transaction);
    }
}
