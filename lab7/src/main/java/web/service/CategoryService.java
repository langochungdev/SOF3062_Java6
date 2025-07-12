package web.service;

import java.util.List;
import web.entity.Category;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    Category save(Category category);
    void delete(Integer id);
}
