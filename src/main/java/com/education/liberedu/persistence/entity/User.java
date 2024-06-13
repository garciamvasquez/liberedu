package com.education.liberedu.persistence.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user_db")
public class User {
    @Id
    private Long idcard;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @Column(name = "role_id",
            insertable = false,
            updatable = false)
    private Long roleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Long getIdcard() {
        return idcard;
    }

    public void setIdcard(Long idcard) {
        this.idcard = idcard;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleid) {
        this.roleId = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}