/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.student;

import com.nicompany.SpringP.school.School;
import com.nicompany.SpringP.student.StudentDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicor
 */
@Service
public class StudentMapper {
    
    
    public Student toStudent(StudentDTO dto){
        if (dto == null) throw new NullPointerException("The Student Dto is null");
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        
        return student;
    }
    
    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstname(),student.getLastname(),student.getEmail());
    }
}
