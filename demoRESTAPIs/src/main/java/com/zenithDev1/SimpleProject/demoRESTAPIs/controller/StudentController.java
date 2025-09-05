package com.zenithDev1.SimpleProject.demoRESTAPIs.controller;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;
import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(){ // @RequestParam("id") long id
        return new StudentDto(4L, "Devendra", "devendra@gmmail.com");
    }

}
