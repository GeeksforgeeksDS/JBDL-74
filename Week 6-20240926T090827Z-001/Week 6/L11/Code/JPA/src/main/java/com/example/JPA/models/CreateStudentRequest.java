package com.example.JPA.models;


import com.example.JPA.studentDB.StudentEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStudentRequest {


    @NotBlank
    String name;
    @NotNull
    Long phoneNumber;
    String emailId;


    public StudentEntity toStudentEntity(){
        return StudentEntity.builder()
                .emailId(emailId)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }


}
