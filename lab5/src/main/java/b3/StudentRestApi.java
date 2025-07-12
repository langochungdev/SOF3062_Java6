package b3;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class StudentRestApi {

    @GetMapping("students.json") // => {key1: student1, key2: student2}
    public Map<String, Student> findAll() {
        return Database.map;
    }

    @GetMapping("students/{key}.json") // => student
    public Student findByKey(@PathVariable("key") String key) {
        return Database.map.get(key);
    }

    @PostMapping("students.json")
    public Map<String, String> create(@RequestBody Student student) {
        String key = student.getId(); // dùng id làm key
        Database.map.put(key, student);
        return Map.of("name", key);
    }


    @PutMapping("students/{key}.json") // => student
    public Student update(@PathVariable("key") String key, @RequestBody Student student) {
        Database.map.put(key, student);
        return Database.map.get(key);
    }

    @DeleteMapping("students/{key}.json") // => nothing
    public void delete(@PathVariable("key") String key) {
        Database.map.remove(key);
    }
}
