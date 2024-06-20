/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.studentprofile;

import com.nicompany.SpringP.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 *
 * @author nicor
 */
@Entity
public class StudentProfile {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String bio;
    @OneToOne
    @JoinColumn(name = "student_Id")
    private Student student;
    public StudentProfile() {}
    
    public StudentProfile(String bio) {
        this.bio = bio;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    
}
