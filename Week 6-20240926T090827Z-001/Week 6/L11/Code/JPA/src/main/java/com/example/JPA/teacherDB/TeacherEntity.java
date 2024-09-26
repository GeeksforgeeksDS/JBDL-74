package com.example.JPA.teacherDB;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TeacherEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "studentGenerator")

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
 */

}
