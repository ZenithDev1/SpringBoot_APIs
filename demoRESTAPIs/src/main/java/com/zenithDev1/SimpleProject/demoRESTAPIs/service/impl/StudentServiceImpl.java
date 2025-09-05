package com.zenithDev1.SimpleProject.demoRESTAPIs.service.impl;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;
import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        return studentDtoList;
    }

}
