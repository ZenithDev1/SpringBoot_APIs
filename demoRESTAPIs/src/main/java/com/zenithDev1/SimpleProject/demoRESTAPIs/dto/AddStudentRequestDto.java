package com.zenithDev1.SimpleProject.demoRESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {

    private String name;
    private String email;
}