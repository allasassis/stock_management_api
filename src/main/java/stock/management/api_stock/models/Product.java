package stock.management.api_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stock.management.api_stock.dto.DataRegisterProduct;
import stock.management.api_stock.dto.DataUpdateProduct;
import stock.management.api_stock.dto.DataUpdateQuantity;
import stock.management.api_stock.exception.StockException;

@Table(name = "products")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String description;
    private String provider;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Product(DataRegisterProduct dataRegisterProduct) {
        this.name = dataRegisterProduct.name();
        this.description = dataRegisterProduct.description();
        this.provider = dataRegisterProduct.provider();
        this.quantity = dataRegisterProduct.quantity();
        this.type = dataRegisterProduct.type();
    }

    public void update(DataUpdateProduct dataUpdateProduct) {
        if(dataUpdateProduct.name() != null) {
            this.name = dataUpdateProduct.name();
        }
        if(dataUpdateProduct.description() != null) {
            this.description = dataUpdateProduct.description();
        }
        if(dataUpdateProduct.provider() != null) {
            this.provider = dataUpdateProduct.provider();
        }
    }

    public void updateQuantity(DataUpdateQuantity dataUpdateQuantity) {
        if (dataUpdateQuantity != null) {
            if (this.quantity <= dataUpdateQuantity.quantity()) {
                this.quantity += dataUpdateQuantity.quantity();
            } else {
                throw new StockException("The quantity is bigger than we have in stock!");
            }
        }
    }
}
