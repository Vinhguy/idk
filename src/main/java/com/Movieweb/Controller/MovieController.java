package com.Movieweb.Controller;

import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private MovieRepo movieRepo;
    @Autowired
    public MovieController(MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }


    @GetMapping(value = "/movies")
    public List<Movie> GetMovies(){
        return  movieRepo.findAll();
    }

    @PostMapping(value = "/create")
    public String PostMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
        return "Created";
    }

    @PutMapping(value = "/update/{id}")
    public Movie PutMovie( @RequestBody Movie movie  , @PathVariable long id){
        Movie UpdatedMovie = new Movie();
        UpdatedMovie = movieRepo.findById(id).get();
        UpdatedMovie.setMovieReview(movie.getMovieReview());
        UpdatedMovie.setMovieProduced(movie.getMovieProduced());
        UpdatedMovie.setMovieName(movie.getMovieName());
        return movieRepo.save(UpdatedMovie);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String DeleteMovie(@PathVariable long id){
        Movie DeletedMovie = new Movie();
        DeletedMovie = movieRepo.findById(id).get();
        movieRepo.delete(DeletedMovie);
        return "oge";
    }
}
