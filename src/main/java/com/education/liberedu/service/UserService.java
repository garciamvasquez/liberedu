package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.RoleCrudRepository;
import com.education.liberedu.persistence.crud.UserCrudRepository;
import com.education.liberedu.persistence.entity.Role;
import com.education.liberedu.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserCrudRepository userCrudRepository;
    @Autowired
    RoleCrudRepository roleCrudRepository;

    public User saveUser(User user) {

        if (user.getRoleId() != null) {
            Role role = roleCrudRepository.findById(user.getRoleId())
                                          .orElseThrow(() -> new RuntimeException(
                                                  "Role not found"));
            user.setRole(role);
        }
        return userCrudRepository.save(user);
    }

    public Optional<User> finalUserById(Long idcard) {
        return userCrudRepository.findById(idcard);
    }

    public Optional<List<User>> findAllUsers() {
        return Optional.of(userCrudRepository.findAll());
    }

    public User updateUser(Long id,
                           User request) {
        User user = userCrudRepository.findById(id)
                                      .get();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setRoleId(request.getRoleId());

        if (request.getRoleId() != null) {
            Role role = roleCrudRepository.findById(request.getRoleId())
                                      .orElseThrow(
                                              () -> new RuntimeException("Role not found"));
            user.setRole(role);
        }

        userCrudRepository.save(user);
        return user;
    }

    public Boolean deleteById(Long id) {
        try {
            userCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
