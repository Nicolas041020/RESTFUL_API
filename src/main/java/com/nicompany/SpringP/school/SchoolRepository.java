/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nicompany.SpringP.school;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nicor
 */
public interface SchoolRepository extends JpaRepository<School, Integer> {
    
}
