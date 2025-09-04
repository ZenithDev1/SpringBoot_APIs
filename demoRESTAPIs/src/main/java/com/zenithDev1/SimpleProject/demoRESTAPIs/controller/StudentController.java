package com.zenithDev1.SimpleProject.demoRESTAPIs.controller;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @GetMapping("/students")
    public StudentDTO getStudent(){
        return new StudentDTO(4L, "Devendra", "devendra@gmmail.com");
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(){ // @RequestParam("id") long id
        return new StudentDTO(4L, "Devendra", "devendra@gmmail.com");
    }

}
