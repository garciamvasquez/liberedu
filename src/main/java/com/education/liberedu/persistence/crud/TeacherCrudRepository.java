package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCrudRepository extends JpaRepository<Teacher, Long> {
}
