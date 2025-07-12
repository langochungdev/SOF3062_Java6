package b2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private StudentMap map = new StudentMap();

    public StudentRestController() {
        map.put("SV01", new Student("SV01", "Tèo", 7.5, true));
        map.put("SV02", new Student("SV02", "Tý", 8.0, false));
    }

    @GetMapping
    public StudentMap getAll() {
        return map;
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable String id) {
        return map.get(id);
    }

    @PostMapping
    public Student post(@RequestBody Student student) {
        map.put(student.getId(), student);
        return student;
    }

    @PutMapping("/{id}")
    public Student put(@PathVariable String id, @RequestBody Student student) {
        map.put(id, student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        map.remove(id);
    }
}
