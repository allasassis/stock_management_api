package stock.management.api_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stock.management.api_stock.dto.RegisterProduct;

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

    public Stock(RegisterProduct registerProduct) {
        this.name = registerProduct.name();
        this.description = registerProduct.description();
        this.provider = registerProduct.provider();
        this.quantity = registerProduct.quantity();
        this.type = registerProduct.type();
    }

    public void update(RegisterProduct registerProduct) {
        if(registerProduct.name() != null) {
            this.name = registerProduct.name();
        }
        if(registerProduct.description() != null) {
            this.description = registerProduct.description();
        }
        if(registerProduct.provider() != null) {
            this.provider = registerProduct.provider();
        }
        if(registerProduct.quantity() != this.quantity) {
            this.quantity += registerProduct.quantity();
        }
    }
}
