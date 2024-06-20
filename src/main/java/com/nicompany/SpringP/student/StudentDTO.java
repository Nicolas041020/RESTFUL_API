/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.nicompany.SpringP.student;

import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author nicor
 */
public record StudentDTO(@NotEmpty(message = "FirstName should not be empty :c") String firstname,@NotEmpty(message = "LastName should not be empty :c")String lastname,String email, Integer schoolId) {

       
      
}
