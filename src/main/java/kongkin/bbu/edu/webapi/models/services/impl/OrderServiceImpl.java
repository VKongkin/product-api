package kongkin.bbu.edu.webapi.models.services.impl;

import kongkin.bbu.edu.webapi.constants.Constants;
import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Order;
import kongkin.bbu.edu.webapi.models.OrderItem;
import kongkin.bbu.edu.webapi.models.repositories.OrderItemRepository;
import kongkin.bbu.edu.webapi.models.repositories.OrderRepository;
import kongkin.bbu.edu.webapi.models.request.OrderItemRequest;
import kongkin.bbu.edu.webapi.models.request.OrderRequest;
import kongkin.bbu.edu.webapi.models.services.OrderService;
import kongkin.bbu.edu.webapi.models.services.ProductService;
import kongkin.bbu.edu.webapi.models.services.UnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UnitTypeService unitTypeService;
    private final ProductService productService;

    @Override
    public List<Order> getAll() throws AppException {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Integer id) throws AppException {
        return orderItemRepository.findAllByOrderId(id);
    }

    @Override
    @Transactional
    public void createOrder(OrderRequest req) throws AppException {
        var create = new Order();
        create.setDate(new Date());
        create.setCreateBy("SYS");
        create.setAmount(req.getAmount());
        create.setDiscount(req.getDiscount());
        create.setCustomerId(0);
        create.setStatus(Constants.STATUS_ACTIVE);
        orderRepository.save(create);
        for (OrderItemRequest item : req.getItems()) {
            var orderItem = new OrderItem();
            orderItem.setOrderId(create.getId());
            orderItem.setQty(item.getQty());
            orderItem.setPrice(item.getPrice());
            orderItem.setDiscount(item.getDiscount());
            var unit = unitTypeService.getUnitTypeById(item.getUnitTypeId());
            orderItem.setUnitType(unit);
            var product = productService.getById(item.getProductId());
            orderItem.setProduct(product);
            orderItemRepository.save(orderItem);
        }
    }
}
