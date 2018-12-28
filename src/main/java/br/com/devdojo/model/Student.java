package br.com.devdojo.model;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Objects;

public class Student {
    
    // Atributos -------------------------------------------
    private int id;
    private String name;
    public static List<Student> studentList;
    
    // Bloco de Inicialização --------------------------------
    
    static {
        studentRepository();
    }
    
    // Contrutores -------------------------------------------
    public Student() {
        
    }
   
    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and Setters -------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> studentList) {
        Student.studentList = studentList;
    }
    
    // ------------------------------
    
    private static void studentRepository() {
        studentList = new ArrayList<>(asList(new Student(1, "Deku"), new Student(2, "Todoroki")));
    }
    
    // Equals and HashCode -----------------------------------
   
    // Obs: Somente o atributo Id deve ser selecionado.

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    
    
    
}