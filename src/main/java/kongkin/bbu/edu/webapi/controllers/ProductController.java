package kongkin.bbu.edu.webapi.controllers;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Category;
import kongkin.bbu.edu.webapi.models.Product;
import kongkin.bbu.edu.webapi.models.ProductUnit;
import kongkin.bbu.edu.webapi.models.response.MessageResponse;
import kongkin.bbu.edu.webapi.models.services.ProductService;
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
public class ProductController extends BaseController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Object> getAll() {
        response = new MessageResponse();
        try {
            List<Product> list = productService.getAll();
            response = new MessageResponse();
            response.getDataSuccess(list);
        } catch (AppException e) {
            log.error("Error while get all products", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response get all products {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products/create")
    public ResponseEntity<Object> create(@RequestBody Product req) {
        response = new MessageResponse();
        try {
            log.info("Interception create product req {}", req);
            productService.create(req);

            response.createDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while create product ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response create product {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        response = new MessageResponse();
        try {
            log.info("Interception get product by id {}", id);
            Product product = productService.getById(id);

            response.getDataSuccess(product);

        } catch (AppException e) {
            log.error("Error while get product by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } finally {
            log.info("Final response get product by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products/update")
    public ResponseEntity<Object> update(@RequestBody Product req) {
        response = new MessageResponse();
        try {
            log.info("Interception update product req {}", req);
            productService.update(req);

            response.updateDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while update product ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response update product {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products/delete")
    public ResponseEntity<Object> delete(@RequestBody Product req) {
        response = new MessageResponse();
        try {
            log.info("Interception delete product req {}", req);
            productService.delete(req);

            response.deleteDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while delete product ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response delete product {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/units/{productId}")
    public ResponseEntity<Object> getAllProductUnitsByProductId(@PathVariable("productId") Integer productId) {
        response = new MessageResponse();
        try {
            List<ProductUnit> list = productService.getProductUnitsByProductId(productId);
            response = new MessageResponse();
            response.getDataSuccess(list);
        } catch (AppException e) {
            log.error("Error while get all product units", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response get all product units {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
