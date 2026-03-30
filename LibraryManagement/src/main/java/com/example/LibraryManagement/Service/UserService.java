package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.UserRepository;
import com.example.LibraryManagement.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;   

    // Create user + send email
    public UserEntity createUser(UserEntity user) {
        UserEntity savedUser = userRepository.save(user);

        // Send email notification
        String subject = "Welcome to Library Management System";
        String body = "Hi " + user.getUsername() +
                ",\n\nYour account has been successfully created!";

        emailService.sendEmail(user.getEmail(), subject, body);

        return savedUser;
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

   public UserEntity updateUser(Long id, UserEntity updatedUser) {

    UserEntity user = userRepository.findById(id).orElse(null);
    if (user == null) {
        throw new RuntimeException("User not found with id " + id);
    }
    user.setUsername(updatedUser.getUsername());
    user.setPassword(updatedUser.getPassword());
    user.setEmail(updatedUser.getEmail());
    return userRepository.save(user);
}

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
