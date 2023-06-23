package com.example.autopartsstore.service.impl;

import com.example.autopartsstore.entity.Role;
import com.example.autopartsstore.entity.User;
import com.example.autopartsstore.repository.UserRepository;
import com.example.autopartsstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return byId;
    }


    @Override
    public User save(User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB.isEmpty()) {
            String password = user.getPassword();
            String encodePassword = passwordEncoder.encode(password);
            user.setPassword(encodePassword);
            user.setRole(Role.USER);
            userRepository.save(user);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
