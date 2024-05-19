package kongkin.bbu.edu.webapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_units")
@Getter
@Setter
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    @ManyToOne
    private UnitType unitType;
    private String  saleDefault; // Y or N
    private double qty;
    private double price;
    private double cost;
}
