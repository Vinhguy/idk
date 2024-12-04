package com.Movieweb.Controller;

import com.Movieweb.DTO.Requests.UserCreationRequest;
import com.Movieweb.DTO.Response.ApiResponse;
import com.Movieweb.DTO.Response.UserResponse;
import com.Movieweb.Models.User;
import com.Movieweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/user")
public class UserController {

    UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ApiResponse<List<UserResponse>> getUser() throws IllegalStateException{
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getuser());
        return apiResponse;
    }
    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
}
