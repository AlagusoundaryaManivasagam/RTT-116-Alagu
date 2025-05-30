package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CreateCustomerFormBean {
    private Integer id;
    //entity should not have any business logic
    //that is why we use this form bean
    //this is analogous to DTO(Data Transfer Object)
    //this is a pojo plain old java object
    //the variable names do need to match exactly the name attribute
    //form bean is old name now its also called as spring bean


    //JSR 303 annotations
    //https://www.geeksforgeeks.org/spring-bean-validation-jsr-303-annotations/
    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "Company name must contain only Letters, numbers and spaces")
    @Length(max = 50, message = "Company name must be less than 50 characters")
    @NotEmpty(message = "Company name is required")
    private String companyName;

    //if we use int then the validation should be not null instead of not empty

    @Length(max = 50, message = "First name must be less than 50 characters")
    @NotEmpty(message = "First Name is required")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters")
    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @Length(max = 50, message = "Phone number must be less than 50 characters")
    @NotEmpty(message = "Phone is required")
    private String phone;

    @Length(max = 50, message = "Address Line must be less than 50 characters")
    @NotEmpty(message = "Address line is required")
    private String addressLine1;

    @Length(max = 50, message = "City must be less than 50 characters")
    @NotEmpty(message = "City is required")
    private String city;

    @Length(max = 50, message = "Country must be less than 50 characters")
    @NotEmpty(message = "Country is required")
    private String country;
    //the variable should be exactly same as name in the form

    private MultipartFile upload;

    private Integer employeeId;

    @Override
    public String toString() {
        return "CreateCustomerFormBean{" +
                "companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
