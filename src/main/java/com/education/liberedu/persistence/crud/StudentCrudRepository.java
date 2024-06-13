package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCrudRepository extends JpaRepository<Student, Long>
{
    Optional<List<Student>> findByParentId(Long parentId);
    
    Optional<List<Student>> findByGroupId(Long groupId);
}
