/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nicompany.SpringP.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nicor
 */
public class StudentMapperTest {
    
//    public StudentMapperTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
    
    
    private StudentMapper studentMapper;
    
    @BeforeEach
    void setUp(){
    studentMapper = new StudentMapper();
    }

    /**
     * Test of toStudent method, of class StudentMapper.
     */
    @Test
    public void testToStudent() {
        StudentDTO dto = new StudentDTO("John","Doe","john@mail.com",1);
        Student student = studentMapper.toStudent(dto);
        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertEquals(dto.schoolId(),student.getSchool().getId());
        assertNotNull(student.getSchool());
        
        
//        System.out.println("toStudent");
//        StudentDTO dto = null;
//        StudentMapper instance = new StudentMapper();
//        Student expResult = null;
//        Student result = instance.toStudent(dto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
    @Test
    public void testThrowToStudentIfStudentDTOIsNull(){
        var e = assertThrows(NullPointerException.class,() -> studentMapper.toStudent(null));
        assertEquals("The Student Dto is null",e.getMessage());
    }
    /**
     * Test of toStudentResponseDto method, of class StudentMapper.
     */
    @Test
    public void testToStudentResponseDto() {
         System.out.println("toStudentResponseDto");
         Student student = new Student("Nicolas","Moreno","Nico@gmail.com",19);
         StudentResponseDto dto = studentMapper.toStudentResponseDto(student);
         assertEquals(student.getFirstname(),dto.firstname());
         assertEquals(student.getLastname(),dto.lastname());
         assertEquals(student.getEmail(),dto.email());
         
        
        
        
        
//        System.out.println("toStudentResponseDto");
//        Student student = null;
//        StudentMapper instance = new StudentMapper();
//        StudentResponseDto expResult = null;
//        StudentResponseDto result = instance.toStudentResponseDto(student);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
   
}
