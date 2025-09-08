package com.zenithDev1.SimpleProject.demoRESTAPIs.controller;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.AddStudentRequestDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
//import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;  connection with entity and respository is not required here
//import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.StudentService;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/students")
public class StudentController{

    private final StudentService studentService;
    

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents()); //studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id)); //studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

}
