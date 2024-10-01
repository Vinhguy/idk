package com.Movieweb.Controller;

import com.Movieweb.DTO.Requests.ApiResponse;
import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Response.MovieResponse;
import com.Movieweb.Models.Movie;
import com.Movieweb.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/newMovie")
     public ApiResponse<MovieResponse> createMovie(@RequestBody MovieCreationRequest request){
        ApiResponse<MovieResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(movieService.createUser(request));
        return apiResponse;
    }

    @GetMapping(value = "/movies")
    public List<Movie> getMovie(){
        return movieService.getMovie();
    }
    @GetMapping(value = "/movies/{id}")
    public Movie getMovie(@PathVariable long id){
        return movieService.getMovie(id);
    }

    @PutMapping(value = "/update/{id}")
    public Movie updateMovie(@PathVariable long id ,@RequestBody MovieCreationRequest request){
        return movieService.updateMovie(id,request);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Deleted");
    }

}
