package com.Movieweb.Controller;

import com.Movieweb.DTO.MovieDTO;
import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import com.Movieweb.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/Movies")
    public Movie createMovie(@RequestBody MovieDTO request){
        MovieService.createUser(request);
    }
}
