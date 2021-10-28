package com.example.E_commerce.Service;

import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.DTO.UserRoleDTO;
import com.example.E_commerce.Entity_or_Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserRoleDTO generateToken(UserRoleDTO userRoleDTO);

    User create(UserDTO userDTO);

    Optional<User> FindByUserId(Long id);

    //Optional<User> updateUser(UserDTO userDTO);

    Optional<User> putupdate(Long id,UserDTO userDTO);

    User deleteById(Long userId);

    List<User> listAll();


}
