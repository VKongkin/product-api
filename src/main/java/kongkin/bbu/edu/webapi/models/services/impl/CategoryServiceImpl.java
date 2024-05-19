package kongkin.bbu.edu.webapi.models.services.impl;

import kongkin.bbu.edu.webapi.constants.Constants;
import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Category;
import kongkin.bbu.edu.webapi.models.repositories.CategoryRepository;
import kongkin.bbu.edu.webapi.models.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() throws AppException {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) throws AppException {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Category req) throws AppException {
        var checkExist = categoryRepository.findByName(req.getName());

        if (checkExist != null) {
            throw new AppException("ERR-002", "Category is already exist!", "Category is already exist!");
        }
        req.setStatus(Constants.STATUS_ACTIVE);
        categoryRepository.save(req);
    }

    @Override
    public void update(Category req) throws AppException {
        var category = getById(req.getId());
        if (category == null) {
            throw new AppException("ERR-001", "CategoryCategory is not found!", "Category is not found!");
        }
        var checkExistName = categoryRepository.findByName(req.getName());

        if (checkExistName != null) {
            if (checkExistName.getId() != category.getId()) {
                throw new AppException("ERR-002", "Category is already exist!", "Category is already exist!");
            }
        }
        req.setStatus(Constants.STATUS_ACTIVE);
        categoryRepository.save(req);
    }

    @Override
    public void delete(Category req) throws AppException {
        var category = getById(req.getId());
        if (category == null) {
            throw new AppException("ERR-001", "CategoryCategory is not found!", "Category is not found!");
        }
        req.setStatus(Constants.STATUS_DELETE);
        categoryRepository.save(req);
    }

    @Override
    public void checkCategoryId(Integer id) throws AppException {
        var category = getById(id);
        if (category == null) {
            throw new AppException("ERR-001", "CategoryCategory is not found!", "Category is not found!");
        }
    }
}
