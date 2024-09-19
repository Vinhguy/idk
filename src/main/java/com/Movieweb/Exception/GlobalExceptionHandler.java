package com.Movieweb.Exception;


import com.Movieweb.DTO.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exception.getMessage());
        return  ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MovieException.class)
    ResponseEntity<ApiResponse> handlingMovieException(MovieException movieException){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(movieException.getErrorCode().getCode());
        apiResponse.setMessage(movieException.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
