package com.example.JPA.models;


import com.example.JPA.teacherDB.TeacherEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTeacherRequest {


    @NotBlank
    String name;
    @NotNull
    Long phoneNumber;
    String emailId;


    public TeacherEntity toTeacherEntity(){
        return TeacherEntity.builder()
                .emailId(emailId)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }


}
