package com.example.JPA.service;

import com.example.JPA.teacherDB.TeacherRepository;
import com.example.JPA.teacherDB.TeacherEntity;
import com.example.JPA.models.CreateTeacherRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public TeacherEntity createTeacher(CreateTeacherRequest request) {
        var newTeacherEntity = request.toTeacherEntity();
        log.info(" CreateTeacherRequest {}  newStudentEntity {} ", request, newTeacherEntity);
        var insertedEntity =  saveOrUpdate(newTeacherEntity);
        log.info(" insertedEntity {}  newStudentEntity {} ", insertedEntity, newTeacherEntity);
        return insertedEntity;
    }


    public TeacherEntity saveOrUpdate(TeacherEntity teacherEntity){
        return teacherRepository.save(teacherEntity);
    }

}
