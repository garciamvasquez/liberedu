package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.StudentCrudRepository;
import com.education.liberedu.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentCrudRepository studentCrudRepository;
    
    public Student save(Student student) {
        return studentCrudRepository.save(student);
    }
    
    public Optional<List<Student>> findAll() {
        return Optional.of(studentCrudRepository.findAll());
    }
    
    public Optional<Student> findById(Long id) {
        return studentCrudRepository.findById(id);
    }
    
    public Optional<List<Student>> findByParentId(Long parentId) {
        return studentCrudRepository.findByParentId(parentId);
    }
    
    public Optional<List<Student>> findByGroupId(Long groupId) {
        return studentCrudRepository.findByGroupId(groupId);
    }
    
    public Student update(Long id, Student request) {
        Student student = studentCrudRepository.findById(id).get();
        
        student.setFirstname(request.getFirstname());
        student.setLastname(request.getLastname());
        student.setEmail(request.getEmail());
        
        return student;
    }
    
    public Boolean deleteById(Long id) {
        try {
            studentCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
