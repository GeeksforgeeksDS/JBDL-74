package com.example.JPA.teacherDB;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @Component directly on indirectly (class level)
 *
 *  How bean is injected --?
 *
 */
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
