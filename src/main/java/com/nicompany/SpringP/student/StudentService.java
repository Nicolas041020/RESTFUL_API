/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.student;

import com.nicompany.SpringP.student.StudentDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author nicor
 */
@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDTO dto) {
        var student = studentMapper.toStudent(dto);
        var savedst = repository.save(student);
        return studentMapper.toStudentResponseDto(savedst);
    }

    public List<StudentResponseDto> findAllStudent() {
        return repository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer studentId) {
        return repository.findById(studentId).map(studentMapper::toStudentResponseDto).orElse(null);
    }

    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name).stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public void delete(@PathVariable("student-id") Integer studentId) {
        repository.deleteById(studentId);
    }
}
