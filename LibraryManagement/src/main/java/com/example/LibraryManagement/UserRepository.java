package com.example.LibraryManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity ,Long> {

   

}
