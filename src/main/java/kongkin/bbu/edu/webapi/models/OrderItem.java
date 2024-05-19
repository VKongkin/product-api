package kongkin.bbu.edu.webapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    @ManyToOne
    private Product product;
    @ManyToOne
    private UnitType unitType;
    private double price;
    private double qty;
    private int discount;
}
