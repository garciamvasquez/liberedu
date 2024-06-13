package com.education.liberedu.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends User
{
    @OneToOne(mappedBy = "teacher")
    private Group group;
    
    @OneToOne(mappedBy = "teacher")
    private Course course;
    
    public Group getGroup() {
        return group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
}
