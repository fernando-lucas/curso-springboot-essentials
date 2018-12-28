package br.com.devdojo.endpoint;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// OBS: Pesquisar sobre: Idempotent Rest (Executar as mesmas requisições varias 
//                                            vezes retorna os mesmos resultados)

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    
    // @Autowired Cria uma instância automaticamente.
    @Autowired
    private DateUtil dateutil;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
//        System.out.println("-------" + dateutil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);
        if (index == -1)
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
                
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student) {
        Student.studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student) {
        Student.studentList.remove(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Student student) {
        Student.studentList.remove(student);
        Student.studentList.add(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
