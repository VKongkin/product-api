package kongkin.bbu.edu.webapi.models.services;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll() throws AppException;
    Category getById(Integer id) throws AppException;
    void create(Category req) throws AppException;
    void update(Category req) throws AppException;
    void delete(Category req) throws AppException;
    void checkCategoryId(Integer id) throws AppException;
}
