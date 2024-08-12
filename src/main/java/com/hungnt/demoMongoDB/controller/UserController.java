package com.hungnt.demoMongoDB.controller;

import com.hungnt.demoMongoDB.dto.request.UserRequest;
import com.hungnt.demoMongoDB.dto.request.UserUpdateRequest;
import com.hungnt.demoMongoDB.dto.response.ApiResponse;
import com.hungnt.demoMongoDB.dto.response.UserResponse;
import com.hungnt.demoMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest userRequest){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(userService.saveUser(userRequest));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(userService.findAllUsers());
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest userUpdateRequest) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(userService.updateUser(id, userUpdateRequest));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable String id){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(userService.deleteUser(id));
        return apiResponse;
    }
}
