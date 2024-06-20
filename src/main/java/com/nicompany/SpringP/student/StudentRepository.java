/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nicompany.SpringP.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nicor
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
    
    List<Student> findAllByFirstnameContaining(String p);
}
