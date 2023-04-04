package stock.management.api_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "stocks")
@Entity(name = "Stock")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String description;
    private String provider;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Type type;

}
