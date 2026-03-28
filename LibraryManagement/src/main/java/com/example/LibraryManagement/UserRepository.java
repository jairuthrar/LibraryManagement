package com.example.LibraryManagement;

import com.example.LibraryManagement.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Optional: find by username or email
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}