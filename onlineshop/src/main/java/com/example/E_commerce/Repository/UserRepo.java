package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity_or_Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    User findByUserId(Long userId);
}
