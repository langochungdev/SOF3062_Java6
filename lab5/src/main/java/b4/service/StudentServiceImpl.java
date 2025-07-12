package b4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b4.dao.StudentDAO;
import b4.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO dao;

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student findById(String id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return dao.save(student);
    }

    @Override
    public Student update(Student student) {
        return dao.save(student);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }
}
