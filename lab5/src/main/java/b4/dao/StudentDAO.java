package b4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import b4.entity.Student;

public interface StudentDAO extends JpaRepository<Student, String> {
}
