package kongkin.bbu.edu.webapi.models.request;

import kongkin.bbu.edu.webapi.models.OrderItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderRequest {
    private int id;
    private Date date;
    private String createBy;
    private int customerId;
    private double amount;
    private int discount;
    private String status;
    public List<OrderItemRequest> items;
}
