package com.Movieweb.Controller;

import com.Movieweb.DTO.Response.ApiResponse;
import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Requests.MovieUpdateRequest;
import com.Movieweb.DTO.Response.MovieResponse;
import com.Movieweb.Services.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    public static Logger logger = LogManager.getLogger(MovieController.class);
    @PostMapping(value = "/newMovie")
     public ApiResponse<MovieResponse> createMovie(@RequestBody MovieCreationRequest request){
        ApiResponse<MovieResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(movieService.createUser(request));
        return apiResponse;
    }

    @GetMapping(value = "/movies")
    public ApiResponse<List> getMovie(){
        ApiResponse<List> apiResponse = new ApiResponse<>();
        apiResponse.setResult(movieService.getMovie());
        return apiResponse;
    }
    @GetMapping(value = "/movies/{id}")
    public ApiResponse<MovieResponse> getMovie(@PathVariable long id){
        ApiResponse<MovieResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(movieService.getMovie(id));
        return apiResponse;
    }

    @PutMapping(value = "/update/{id}")
    public ApiResponse<MovieResponse> updateMovie(@PathVariable long id , @RequestBody MovieUpdateRequest request){
        ApiResponse<MovieResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(movieService.updateMovie(id,request));
        return apiResponse;
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Deleted");
    }

}
