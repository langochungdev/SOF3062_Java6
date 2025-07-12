package b4.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import b4.entity.Student;
import b4.service.StudentService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentRestApi {

    @Autowired
    StudentService studentService;

    @GetMapping("students") // => [student1, student2,...]
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("students/{id}") // => student
    public Student findById(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    @PostMapping("students") // => student
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("students/{id}") // => student
    public Student update(@PathVariable("id") String id, @RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("students/{id}") // => nothing
    public void delete(@PathVariable("id") String id) {
        studentService.deleteById(id);
    }
}
