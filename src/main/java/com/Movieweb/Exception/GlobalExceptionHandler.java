package com.Movieweb.Exception;


import com.Movieweb.DTO.Response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(Exception exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exception.getMessage());
        return  ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingMovieException(AppException appException){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(appException.getErrorCode().getCode());
        apiResponse.setMessage(appException.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
