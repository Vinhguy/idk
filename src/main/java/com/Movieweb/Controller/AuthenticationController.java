package com.Movieweb.Controller;

import com.Movieweb.DTO.Requests.AuthenticationRequest;
import com.Movieweb.DTO.Response.ApiResponse;
import com.Movieweb.DTO.Response.AuthenticationResponse;
import com.Movieweb.Services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    Logger logger = LogManager.getLogger(AuthenticationController.class);
    AuthenticationService authenticationService;
    @PostMapping(value = "/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
