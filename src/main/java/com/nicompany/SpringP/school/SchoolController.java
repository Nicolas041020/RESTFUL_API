/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.school;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicor
 */
@RestController
public class SchoolController {
    
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
       return schoolService.create(dto);
    }
    
    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolService.findAll();
    }
}
