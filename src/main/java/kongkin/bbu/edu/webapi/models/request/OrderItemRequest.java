package kongkin.bbu.edu.webapi.models.request;

import jakarta.persistence.ManyToOne;
import kongkin.bbu.edu.webapi.models.OrderItem;
import kongkin.bbu.edu.webapi.models.Product;
import kongkin.bbu.edu.webapi.models.UnitType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderItemRequest {
    private int id;
    private int orderId;
    private int productId;
    private int unitTypeId;
    private double price;
    private double qty;
    private int discount;
}
