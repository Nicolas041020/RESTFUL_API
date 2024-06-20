/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.school;

import com.nicompany.SpringP.school.SchoolDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicor
 */
@Service
public class SchoolMapper {
    
    
     public School toSchool(SchoolDto dto){
        return new School(dto.name());
}
    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
