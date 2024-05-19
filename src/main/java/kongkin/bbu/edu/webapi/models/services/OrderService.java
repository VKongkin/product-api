package kongkin.bbu.edu.webapi.models.services;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Order;
import kongkin.bbu.edu.webapi.models.OrderItem;
import kongkin.bbu.edu.webapi.models.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAll() throws AppException;
    List<OrderItem> getOrderItemByOrderId(Integer id) throws AppException;
    void createOrder(OrderRequest req) throws AppException;

}
