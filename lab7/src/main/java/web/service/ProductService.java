package web.service;

import java.util.List;
import web.entity.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Product save(Product product);
    void delete(Integer id);
}
