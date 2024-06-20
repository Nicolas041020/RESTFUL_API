/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicompany.SpringP.school;

import com.nicompany.SpringP.school.SchoolDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicor
 */
@Service
public class SchoolService {
    
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;
    
    public SchoolService (SchoolMapper schoolMapper,SchoolRepository schoolRepository){
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }
    
   public SchoolDto create(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }
   
   public List<SchoolDto> findAll(){
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }
    
}
