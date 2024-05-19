package kongkin.bbu.edu.webapi.models.services;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Category;
import kongkin.bbu.edu.webapi.models.Product;
import kongkin.bbu.edu.webapi.models.ProductUnit;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws AppException;
    void create(Product req) throws AppException;

    Product getById(Integer id) throws AppException;
    void update(Product req) throws AppException;
    void delete(Product req) throws AppException;
    List<ProductUnit> getProductUnitsByProductId(Integer id) throws AppException;
}
