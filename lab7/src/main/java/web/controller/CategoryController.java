package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.entity.Category;
import web.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepo.save(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        if (!categoryRepo.existsById(id)) return null;
        return categoryRepo.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryRepo.deleteById(id);
    }
}
