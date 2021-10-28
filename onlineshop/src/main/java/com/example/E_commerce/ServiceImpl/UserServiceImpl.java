package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.DTO.UserRoleDTO;
import com.example.E_commerce.Entity_or_Model.Role;
import com.example.E_commerce.Entity_or_Model.User;
import com.example.E_commerce.Exception.ControllerException;

import com.example.E_commerce.Repository.UserRepo;
import com.example.E_commerce.Service.UserService;
import com.example.E_commerce.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User create(UserDTO userDTO) {
        User user= new User();
        user.setUserName(userDTO.getUserName());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setPassword(bcrypt.encode(userDTO.getPassword()));
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        List<Role> roleList = new LinkedList<>();
        userDTO.getRole().stream().forEachOrdered(role -> {
            roleList.add(role);
        });

        user.setListofrole(roleList);
        userRepo.save(user);
        return user;
    }

    @Override
    public UserRoleDTO generateToken(UserRoleDTO userRoleDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        List<Role> roles = new LinkedList<>();
        try {
            Optional<User> user = userRepo.findByUserName(userRoleDTO.getUserName());
            boolean status = bcrypt.matches(userRoleDTO.getPassword(), user.get().getPassword());
            if (user.isPresent() && status == true) {
                user.get().getListofrole().stream().forEachOrdered(role -> {
                    Role role1 = new Role();
                    role1.setRoleName(role.getRoleName());
                    roles.add(role);
                });
                String Token = JwtUtil.generateToken("secret", user.get().getUserId(), "user", user.get().getUserName(), roles);
                userRoleDTO.setUserName(user.get().getUserName());
                userRoleDTO.setUserId(user.get().getUserId());
                userRoleDTO.setJwtToken(Token);
            }
        }  catch (NoSuchElementException e) {
            throw new ControllerException("401","Unauthorised");
        }
        return userRoleDTO;
    }

    public UserDetails loadByuserName(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepo.findByUserName(username);
        List<Role> roles = new LinkedList<>();
        if (userDetail == null) {
            throw new ControllerException("404","User details Not Found");
        } else {
            userDetail.get().getListofrole().stream().forEachOrdered(role -> {
                Role role1 = new Role();
                role1.setRoleName(role.getRoleName());
                roles.add(role);
            });
            return new org.springframework.security.core.userdetails.User(userDetail.get().getUserName(), userDetail.get().getPassword(), getAuthority(roles));
        }
    }


    private List getAuthority(List<Role> role){
        List authorities=new ArrayList();
        role.stream().forEachOrdered(roleget -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +roleget.getRoleName()));
        });
        return authorities;
    }

    @Override
    public Optional<User> FindByUserId(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @Override
    public Optional<User> putupdate(Long id, UserDTO userDTO) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()) {
            user.get().setUserName(user.get().getUserName());
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            user.get().setPassword(bcrypt.encode(userDTO.getPassword()));
            user.get().setPhoneNumber(userDTO.getPhoneNumber());
            user.get().setEmail(userDTO.getEmail());
            user.get().setIsActive(user.get().getIsActive());
            user.get().setIsDelete(user.get().getIsDelete());

            List<Role> roleList = new LinkedList<>();
            userDTO.getRole().stream().forEachOrdered(role -> {
                roleList.add(role);
            });

            user.get().setListofrole(roleList);
            userRepo.save(user.get());
            return user;
        }
        else {
            throw new RuntimeException("Please enter a valid user id");
        }
    }
    @Override
    public User deleteById(Long userId) {
        User user = new User();
        userRepo.deleteById(userId);
        return user;
    }

    @Override
    public List<User>listAll() {
        List<User> users = userRepo.findAll();
        return users;
    }

}
