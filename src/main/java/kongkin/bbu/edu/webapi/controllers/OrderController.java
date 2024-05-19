package kongkin.bbu.edu.webapi.controllers;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Order;
import kongkin.bbu.edu.webapi.models.Product;
import kongkin.bbu.edu.webapi.models.request.OrderRequest;
import kongkin.bbu.edu.webapi.models.response.MessageResponse;
import kongkin.bbu.edu.webapi.models.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController extends BaseController{
    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<Object> getAll() {
        response = new MessageResponse();
        try {
            List<Order> list = orderService.getAll();
            response = new MessageResponse();
            response.getDataSuccess(list);
        } catch (AppException e) {
            log.error("Error while get all orders", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response get all orders {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/orders/items/{orderId}")
    public ResponseEntity<Object> getAllOrderItemsByOrderId(@PathVariable("orderId") Integer orderId) {
        response = new MessageResponse();
        try {
            log.info("Intercept get all order items");
            var list = orderService.getOrderItemByOrderId(orderId);
            response.getDataSuccess(list);
        } catch (AppException e) {
            log.error("Error while get all order items", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response get all order items {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/orders/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequest req) {
        response = new MessageResponse();
        try {
            log.info("Intercept create order {}", req);
            orderService.createOrder(req);
            response.createDataSuccess(null);
        } catch (AppException e) {
            log.error("Error while create order", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response create orders {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
