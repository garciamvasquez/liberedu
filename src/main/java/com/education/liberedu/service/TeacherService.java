package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.RoleCrudRepository;
import com.education.liberedu.persistence.crud.TeacherCrudRepository;
import com.education.liberedu.persistence.entity.Role;
import com.education.liberedu.persistence.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherCrudRepository teacherCrudRepository;
    @Autowired
    private RoleCrudRepository    roleCrudRepository;

    @Transactional
    public Teacher saveTeacher(Teacher teacher) {

        if (teacher.getRoleId() != null) {
            Role role = roleCrudRepository.findById(teacher.getRoleId())
                                          .orElseThrow(() -> new RuntimeException(
                                                  "Role not found"));
            teacher.setRole(role);
        }
        return teacherCrudRepository.save(teacher);
    }

    public Optional<Teacher> findTeacherById(Long id) {
        return teacherCrudRepository.findById(id);
    }

    public Optional<List<Teacher>> findAllTeachers() {
        return Optional.of(teacherCrudRepository.findAll());
    }

    @Transactional
    public Teacher updateTeacher(Long id,
                                 Teacher request) {
        Teacher teacher = teacherCrudRepository.findById(id)
                                               .get();

        teacher.setFirstname(request.getFirstname());
        teacher.setLastname(request.getLastname());
        teacher.setEmail(request.getEmail());

        if (request.getRoleId() != null) {
            Role role = roleCrudRepository.findById(request.getRoleId())
                                          .orElseThrow(() -> new RuntimeException(
                                                  "Role not found"));
            teacher.setRole(role);
        }

        teacherCrudRepository.save(teacher);

        return teacher;
    }

    public Boolean deleteTeacher(Long id) {
        try {
            teacherCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
