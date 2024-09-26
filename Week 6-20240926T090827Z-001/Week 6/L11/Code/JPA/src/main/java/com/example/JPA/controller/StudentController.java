package com.example.JPA.controller;


import com.example.JPA.studentDB.StudentEntity;
import com.example.JPA.teacherDB.TeacherEntity;
import com.example.JPA.models.CreateStudentRequest;
import com.example.JPA.models.CreateTeacherRequest;
import com.example.JPA.service.StudentService;
import com.example.JPA.service.TeacherService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
//@AllArgsConstructor
public class StudentController {

    // various ways to inject dependency

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;


    // which is most preferred one ? -- contructor
    // why ??       ---->

    // Dependency Injection takes place



    @PostMapping(value = "/v1/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentEntity> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        log.info(" create request {} ", createStudentRequest);
        return ResponseEntity.ok(studentService.createStudent(createStudentRequest));
    }



    @PostMapping(value = "/v1/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherEntity> createTeacher(@Valid @RequestBody CreateTeacherRequest request){
        log.info(" create request {} ", request);
        return ResponseEntity.ok(teacherService.createTeacher(request));
    }






//    @GetMapping(value = "/v1/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StudentEntity> findStudentById(@PathVariable(required = true) String id){
//        log.info(" fetchStudentInfo {} ", id);
//        return ResponseEntity.ok(studentService.findStudentInfoById(id));
//    }



}
