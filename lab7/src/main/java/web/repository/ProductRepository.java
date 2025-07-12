package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
