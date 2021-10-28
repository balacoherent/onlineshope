package com.example.E_commerce.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRoleDTO {

    private Long userId;

    private String UserName;

    private String jwtToken;

    private String password;

}

