package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.DTO.UserRoleDTO;
import com.example.E_commerce.Entity_or_Model.User;
import com.example.E_commerce.Service.UserService;
import com.example.E_commerce.ServiceImpl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private UserServiceImpl userServices;

    @PostMapping("/post")
    public BaseResponse<User> create(@RequestBody UserDTO userDTO) {
        BaseResponse<User> baseResponse;
        baseResponse = BaseResponse.<User>builder().data(userService.create(userDTO)).build();
        return baseResponse;
    }

    @ApiOperation(value = "user login ")
    @GetMapping("/login")
    public BaseResponse<UserRoleDTO> tokenGenerate(@RequestBody UserRoleDTO userRoleDTO) {
        BaseResponse<UserRoleDTO> baseResponse;
        baseResponse = BaseResponse.<UserRoleDTO>builder().data(userService.generateToken(userRoleDTO)).build();
        return baseResponse;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/{id}")
    public BaseResponse<Optional<User>> FindByUserId(@PathVariable Long id){
        BaseResponse<Optional<User>> baseResponse= null;
        baseResponse = BaseResponse.<Optional<User>>builder().data(userService.FindByUserId(id)).build();
        return baseResponse;
    }

   /* @RolesAllowed(value = "USER")
    @PutMapping("/putupdate")
    public BaseResponse<Optional<User>> putupdate(@RequestParam Long id,@RequestBody UserDTO userDTO)
    {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse = BaseResponse.<Optional<User>>builder().data(userService.updateUser(id, userDTO)).build();
        return baseResponse;
    }
*/

    @PutMapping("/putupdate")
    public BaseResponse<Optional<User>> putupdate(@RequestParam Long id,@RequestBody UserDTO userDTO)
    {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse = BaseResponse.<Optional<User>>builder().data(userService.putupdate(id, userDTO)).build();
        return baseResponse;
    }

    @RolesAllowed(value = "ADMIN")
    @DeleteMapping("/delete/{id}")
    public String deletesoft (@PathVariable Long userId){
        userService.deleteById(userId);
        return "Success";
    }

    @RolesAllowed(value = "ADMIN")
    @GetMapping("/getall")
    public BaseResponse <List<User>> listAll(){
        BaseResponse<List<User>> baseResponse= null;
        baseResponse = BaseResponse.<List<User>>builder().data(userService.listAll()).build();
        return baseResponse;
    }

}
