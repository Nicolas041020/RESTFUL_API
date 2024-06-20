/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nicompany.SpringP.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author nicor
 */
public class StudentServiceTest {
    
    public StudentServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveStudent method, of class StudentService.
     */
    
    
    // which service we want to test
    @InjectMocks
    private StudentService studentService;
    
    //declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;
    
    @Test
    public void testSaveStudent() {
        
        //Given
        StudentDTO dto = new StudentDTO("John","Doe","john@mail.com",1);
        Student student = new Student("John","Doe","john@mail.com",20);
        Student savedStudent = new Student("John","Doe","john@mail.com",20);
        savedStudent.setId(1);
        
        //Mock the calls
//        var student = studentMapper.toStudent(dto);
//        var savedst = repository.save(student);
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("John","Doe","john@mail.com"));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);
        
        //Then
        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());
        
        verify(studentMapper,times(1)).toStudent(dto);
        verify(repository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudentResponseDto(savedStudent);
        
        
        
        
//        System.out.println("saveStudent");
//        StudentDTO dto = null;
//        StudentService instance = null;
//        StudentResponseDto expResult = null;
//        StudentResponseDto result = instance.saveStudent(dto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllStudent method, of class StudentService.
     */
    @Test
    public void testFindAllStudent() {
        // Given 
        Student student = new Student("John","Doe","john@mail.com",20);
        List<Student> students = new ArrayList();
        students.add(student);
        
        //Mock calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Doe","john@mail.com"));
        //When
         List<StudentResponseDto> list2 = studentService.findAllStudent();
        //Then
        assertEquals(students.size(),list2.size());
        assertEquals(students.get(0).getFirstname(),list2.get(0).firstname());
        verify(repository,times(1)).findAll();
        
        
//        System.out.println("findAllStudent");
//        StudentService instance = null;
//        List<StudentResponseDto> expResult = null;
//        List<StudentResponseDto> result = instance.findAllStudent();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findStudentById method, of class StudentService.
     */
    @Test
    public void testFindStudentById() {
        //Given
        Integer StudentId = 1;
         Student student = new Student("John","Doe","john@mail.com",20);
        
        // Mock calls
        when(repository.findById(StudentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Doe","john@mail.com"));
        
        //When
        StudentResponseDto dto = studentService.findStudentById(StudentId);
        //Then
        assertEquals(student.getFirstname(), dto.firstname());
        assertEquals(student.getLastname(), dto.lastname());
        assertEquals(student.getEmail(), dto.email());
        
        verify(repository, times(1)).findById(StudentId);
        
//        System.out.println("findStudentById");
//        Integer studentId = null;
//        StudentService instance = null;
//        StudentResponseDto expResult = null;
//        StudentResponseDto result = instance.findStudentById(studentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findStudentsByName method, of class StudentService.
     */
    @Test
    public void testFindStudentsByName() {
        
        //Given
         Student student = new Student("John","Doe","john@mail.com",20);
        List<Student> students = new ArrayList();
        students.add(student);
        // Mock calls
        when(repository.findAllByFirstnameContaining(student.getFirstname())).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Doe","john@mail.com"));
        
        //When
        List<StudentResponseDto> dto = studentService.findStudentsByName(student.getFirstname());
        //Then
        assertEquals(dto.size(),students.size());
        
        verify(repository, times(1)).findAllByFirstnameContaining(student.getFirstname());
       
        
        
//        System.out.println("findStudentsByName");
//        String name = "";
//        StudentService instance = null;
//        List<StudentResponseDto> expResult = null;
//        List<StudentResponseDto> result = instance.findStudentsByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class StudentService.
     */
    @Test
    public void testDelete() {
//        System.out.println("delete");
//        Integer studentId = null;
//        StudentService instance = null;
//        instance.delete(studentId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
