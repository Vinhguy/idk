package com.Movieweb.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private int code; //http code
    private String message;
    private T result ;
}
