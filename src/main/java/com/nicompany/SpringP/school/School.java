/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nicompany.SpringP.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author nicor
 */
@Entity
public class School {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;
    public School(){}
    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
}
