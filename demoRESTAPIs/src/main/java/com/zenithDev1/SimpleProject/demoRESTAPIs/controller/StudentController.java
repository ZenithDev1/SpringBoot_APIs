package com.zenithDev1.SimpleProject.demoRESTAPIs.controller;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
//import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;  connection with entity and respository is not required here
//import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.StudentService;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequiredArgsConstructor
public class StudentController{

    private final StudentService studentService;
    

    @GetMapping("/students")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

}
