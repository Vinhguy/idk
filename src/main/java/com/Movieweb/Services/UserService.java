package com.Movieweb.Services;
import com.Movieweb.DTO.Requests.UserCreationRequest;
import com.Movieweb.DTO.Response.UserResponse;
import com.Movieweb.Mapper.UserMapper;
import com.Movieweb.Models.User;
import com.Movieweb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserMapper userMapper;

    public List<UserResponse> getuser() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        List<UserResponse> userResponses = users.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
        if (userResponses.isEmpty()) {
            throw new RuntimeException("Mapping failed, no userResponses were created");
        }
        return userResponses;
    }


    public UserResponse getUser(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Wrong id"));
        return userMapper.toUserResponse(user);
    }

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("user already exists");
        }

        User user = userMapper.toUser(request);
        PasswordEncoder encoder = new BCryptPasswordEncoder(6);
        user.setPassword(encoder.encode(request.getPassword()));
        return userMapper.toUserResponse(userRepo.save(user));
    }
}
