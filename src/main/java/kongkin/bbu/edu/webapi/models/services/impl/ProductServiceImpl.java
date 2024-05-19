package kongkin.bbu.edu.webapi.models.services.impl;

import kongkin.bbu.edu.webapi.constants.Constants;
import kongkin.bbu.edu.webapi.constants.ErrorCode;
import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Category;
import kongkin.bbu.edu.webapi.models.Product;
import kongkin.bbu.edu.webapi.models.ProductUnit;
import kongkin.bbu.edu.webapi.models.repositories.ProductRepository;
import kongkin.bbu.edu.webapi.models.repositories.ProductUnitRepository;
import kongkin.bbu.edu.webapi.models.services.CategoryService;
import kongkin.bbu.edu.webapi.models.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductUnitRepository productUnitRepository;
    @Override
    public List<Product> getAll() throws AppException {
        return productRepository.findAll();
    }

    @Override
    public void create(Product req) throws AppException {
        if(req.getCategory()==null){
            throw new AppException(ErrorCode.FIELD_IS_REQUIRED,"Field is required!","Field is required!");
        }
        categoryService.checkCategoryId(req.getCategory().getId());
        req.setStatus(Constants.STATUS_ACTIVE);
        productRepository.save(req);
    }

    @Override
    public Product getById(Integer id) throws AppException {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product req) throws AppException {
        var checkProduct = getById(req.getId());
        if (checkProduct == null){
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND,"Product not found!","Product not found!");
        }
        categoryService.checkCategoryId(req.getCategory().getId());
        req.setStatus(Constants.STATUS_ACTIVE);
        productRepository.save(req);
    }

    @Override
    public void delete(Product req) throws AppException {
        categoryService.checkCategoryId(req.getCategory().getId());
        req.setStatus(Constants.STATUS_DELETE);
        productRepository.save(req);
    }

    @Override
    public List<ProductUnit> getProductUnitsByProductId(Integer id) throws AppException {
        return productUnitRepository.findAllByProductId(id);
    }
}
