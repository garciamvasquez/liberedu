package com.education.liberedu.controller;

import com.education.liberedu.persistence.entity.Teacher;
import com.education.liberedu.persistence.entity.Teacher;
import com.education.liberedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(savedTeacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.findTeacherById(id)
                                        .get();
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @GetMapping
    public Optional<List<Teacher>> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable("id") Long id,
                                 @RequestBody Teacher request) {
        return teacherService.updateTeacher(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteTeacher(@PathVariable("id") Long id) {
        return teacherService.deleteTeacher(id);
    }
}
