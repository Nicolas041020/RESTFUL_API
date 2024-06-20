/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.student;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 *
 * @author nicor
 */
@RestController
public class StudentController {
    
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDTO dto) {
        return studentService.saveStudent(dto);
    }
    
    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }
    
    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer studentId) {
        return studentService.findStudentById(studentId);
    }
    
    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name") String name) {
        return studentService.findStudentsByName(name);
    }
    
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer studentId) {
        studentService.delete(studentId);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
