package com.example.JPA.studentDB;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "phoneNumber", unique = true)})
public class StudentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "studentGenerator")
    @TableGenerator(name = "studentGenerator", allocationSize = 4, initialValue = 9)

    Long id;

    String name;
    Long phoneNumber;
    String emailId;


/**
 *
 *
 * No @GeneratedValue
 * Hibernate: drop table if exists student_entity
 * Hibernate: create table student_entity (id bigint not null, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB
 *
 /**
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 (Managed at SQL)
 Hibernate: drop table if exists student_entity
 Hibernate: create table student_entity (id bigint not null auto_increment, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB     *
 Hibernate: insert into student_entity (email_id,name,phone_number) values (?,?,?)



 @GeneratedValue(strategy = GenerationType.UUID)
 (Managed by Hibernate)
 Hibernate: drop table if exists student_entity
 Hibernate: create table student_entity (phone_number bigint, email_id varchar(255), id varchar(255) not null, name varchar(255), primary key (id)) engine=InnoDB

 phoneNumber=9911991199, emailId=Joey@gmail.com)  newStudentEntity StudentEntity(id=null, name=Joey, phoneNumber=9911991199, emailId=Joey@gmail.com)
 Hibernate: insert into student_entity (email_id,name,phone_number,id) values (?,?,?,?)

 @GeneratedValue(strategy = GenerationType.TABLE)
 Hibernate: create table hibernate_sequences (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
 Hibernate: insert into hibernate_sequences(sequence_name, next_val) values ('default',0)


 for student
 @GeneratedValue(strategy = GenerationType.TABLE, generator = "custom_generator")
 for teacher
 @GeneratedValue(strategy = GenerationType.TABLE, generator = "custom_generator")

 Hibernate: drop table if exists custom_generator
 Hibernate: drop table if exists student_entity
 Hibernate: drop table if exists teacher_entity
 Hibernate: create table custom_generator (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
 Hibernate: insert into custom_generator(sequence_name, next_val) values ('teacher_entity',0)
 Hibernate: insert into custom_generator(sequence_name, next_val) values ('student_entity',0)
 Hibernate: create table student_entity (id bigint not null, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB
 Hibernate: create table teacher_entity (id bigint not null, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB

 for student
 @GeneratedValue(strategy = GenerationType.TABLE, generator = "studentGenerator")

 for teacher
 @GeneratedValue(strategy = GenerationType.TABLE, generator = "teacherGenerator")

 Hibernate: create table student_entity (id bigint not null, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB
 Hibernate: create table student_generator (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
 Hibernate: insert into student_generator(sequence_name, next_val) values ('student_entity',9)
 Hibernate: create table teacher_entity (id bigint not null, phone_number bigint, email_id varchar(255), name varchar(255), primary key (id)) engine=InnoDB
 Hibernate: create table teacher_generator (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
 Hibernate: insert into teacher_generator(sequence_name, next_val) values ('teacher_entity',0)



 */

}
