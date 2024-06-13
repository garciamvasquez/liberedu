package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupCrudRepository extends JpaRepository<Group, Long>
{
    Optional<Group> findByTeacherId(Long teacherId);
}
