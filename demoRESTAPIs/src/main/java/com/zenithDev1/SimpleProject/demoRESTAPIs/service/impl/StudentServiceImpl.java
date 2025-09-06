package com.zenithDev1.SimpleProject.demoRESTAPIs.service.impl;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;
import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        // return studentDtoLis;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Found NO Student with Id: "+id));
        return modelMapper.map(student, StudentDto.class);
    }

}
