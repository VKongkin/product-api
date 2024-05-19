package kongkin.bbu.edu.webapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "unit_type")
@Getter
@Setter
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double qty;

    public UnitType(String name, double qty) {
        this.name = name;
        this.qty = qty;
    }

    public UnitType() {

    }
}
