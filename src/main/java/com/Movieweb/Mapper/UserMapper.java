package com.Movieweb.Mapper;

import com.Movieweb.DTO.Requests.UserCreationRequest;
import com.Movieweb.DTO.Response.UserResponse;
import com.Movieweb.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
}
