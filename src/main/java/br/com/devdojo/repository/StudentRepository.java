package br.com.devdojo.repository;

import br.com.devdojo.model.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
}
