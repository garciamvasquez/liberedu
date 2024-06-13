package com.education.liberedu.controller;

import com.education.liberedu.service.StudentService;
import com.education.liberedu.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public Optional<List<Student>> findAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> findStudent(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable("id") Long id,
                                 @RequestBody Student request) {
        return studentService.update(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteById(id);
    }
}
