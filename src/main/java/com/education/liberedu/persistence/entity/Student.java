package com.education.liberedu.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student extends User
{
    @Column(name = "parent_id", insertable = false, updatable = false)
    private Long parentId;
    
    @Column(name = "group_id", insertable = false, updatable = false)
    private Long groupId;
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    
    @OneToMany(mappedBy = "student")
    private List<Grade> courseGrades;
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public Long getGroupId() {
        return groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    
    public Parent getParent() {
        return parent;
    }
    
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    public Group getGroup() {
        return group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    
    public List<Grade> getCourseGrades() {
        return courseGrades;
    }
    
    public void setCourseGrades(List<Grade> courseGrades) {
        this.courseGrades = courseGrades;
    }
}
