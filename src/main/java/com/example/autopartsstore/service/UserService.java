package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findById(int id);

    User save(User user);
    void deleteById(int id);
}
