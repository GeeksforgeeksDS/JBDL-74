package com.example.JPA.service;

import com.example.JPA.studentDB.StudentRepository;
import com.example.JPA.studentDB.StudentEntity;
import com.example.JPA.models.CreateStudentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;


    public StudentEntity createStudent(CreateStudentRequest createStudentRequest) {
        var newStudentEntity = createStudentRequest.toStudentEntity();
        log.info(" createStudentRequest {}  newStudentEntity {} ", createStudentRequest, newStudentEntity);

        // check if duplicate exists
        var byPhoneNumber = studentRepository.findByPhoneNumber(newStudentEntity.getPhoneNumber());
        if(byPhoneNumber.isPresent()){
            throw new RuntimeException("UserExists");
        }
        var insertedEntity =  saveOrUpdate(newStudentEntity);
        log.info(" insertedEntity {}  newStudentEntity {} ", insertedEntity, newStudentEntity);
        return insertedEntity;
    }


    public StudentEntity saveOrUpdate(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

//    public StudentEntity findStudentInfoById(String id) {
//        return studentRepository.findById(id).orElse(null);
//    }
}
