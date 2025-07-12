package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
