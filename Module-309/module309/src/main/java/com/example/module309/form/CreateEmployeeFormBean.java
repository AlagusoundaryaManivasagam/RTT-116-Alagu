package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {
    private Integer id;

    @Pattern(regexp = "[A-Za-z\\s]+", message = "First Name must contain only letters")
    @Length(max = 50, message = "First Name must be less than 50 characters")
    @NotEmpty(message = "First Name is required")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]+", message = "Last Name must contain only letters and spaces")
    @Length(max = 50, message = "Last Name must be less than 50 characters")
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @Pattern(regexp = "^x[0-9]+$", message = "Extension should start with x and contain only digits after x")
    @Length(max = 10, message = "Extension must be less than 10 characters")
    @NotEmpty(message = "Extension  is required")
    private String extension;

    @Pattern(regexp = ".+@.+\\..+", message = "Invalid email form")
    @Length(max = 100, message = "Email must be less than 100 characters")
    @NotEmpty(message = "Email is required")
    private String email;

    @Length(max = 50, message = "Job title must be less than 50 characters")
    @NotEmpty(message = "Job tittle is required")
    private String jobTitle;
}
