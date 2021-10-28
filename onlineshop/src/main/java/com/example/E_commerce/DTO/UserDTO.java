package com.example.E_commerce.DTO;

import com.example.E_commerce.Entity_or_Model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDTO {

    private Long userId;

    private String userName;

    private String password;

    private String email;

    private  Long phoneNumber;

    private List<Role> role;

}
