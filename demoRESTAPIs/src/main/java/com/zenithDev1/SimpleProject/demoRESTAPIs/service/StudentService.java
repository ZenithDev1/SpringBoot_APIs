package com.zenithDev1.SimpleProject.demoRESTAPIs.service;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
