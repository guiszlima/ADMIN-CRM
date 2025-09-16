package com.guiszlima.crm_admin_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.guiszlima.crm_admin_backend.repository.UserRepository;
import com.guiszlima.crm_admin_backend.model.User;

public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Lógica para registrar um novo usuário
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        // Lógica para autenticar um usuário
        User user = new User();
        return user;
    }
}