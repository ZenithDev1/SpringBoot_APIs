package com.zenithDev1.SimpleProject.demoRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {

    @NotBlank(message = "Name is Manadatory")
    private String name;

    @Email
    @NotBlank(message = "Email is Required Field")
    private String email;
}