package com.zenithDev1.SimpleProject.demoRESTAPIs.service.impl;

import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.AddStudentRequestDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.dto.StudentDto;
import com.zenithDev1.SimpleProject.demoRESTAPIs.entity.Student;
import com.zenithDev1.SimpleProject.demoRESTAPIs.repository.StudentRepository;
import com.zenithDev1.SimpleProject.demoRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    //private final AddStudentRequestDto addStudentRequestDto;

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Found NO Student with Id: "+id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with Id: "+id+" does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with Id: "+id+" does not exist"));

        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with Id: "+id+" does not exist"));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: "+field);
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }


}
