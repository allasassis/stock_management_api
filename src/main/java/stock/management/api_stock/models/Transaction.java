package stock.management.api_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "transactions")
@Entity(name = "Transaction")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction(User user, LocalDateTime dateTime, TransactionType transactionType) {
        this.user = user;
        this.dateTime = dateTime;
        this.transactionType = transactionType;
    }
}
