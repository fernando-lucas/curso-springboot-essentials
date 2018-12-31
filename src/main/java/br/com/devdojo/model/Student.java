package br.com.devdojo.model;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

    // Atributos -------------------------------------------
    private String name;

    // Getters and Setters -------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
