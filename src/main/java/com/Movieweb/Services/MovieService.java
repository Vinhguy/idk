package com.Movieweb.Services;

import com.Movieweb.DTO.UserCreationRequest;
import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }


    public Movie createUser(UserCreationRequest request){
        Movie movie = new Movie();
        if(movieRepo.existsByMoviename(request.getMoviename()))
            throw new RuntimeException("BOOM existed");

        movie.setMoviereview(request.getMoviereview());
        movie.setMovieproduced(request.getMovieproduced());
        movie.setMoviename(request.getMoviename());
        return movieRepo.save(movie);
    }
    public List<Movie> getMovie(){
        return movieRepo.findAll();
    }

    public Movie getMovie(long id){
        return movieRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Movie updateMovie(long id, UserCreationRequest request){
        Movie movie = getMovie(id);
        movie.setMoviereview(request.getMoviereview());
        movie.setMovieproduced(request.getMovieproduced());
        movie.setMoviename(request.getMoviename());
        return movieRepo.save(movie);
    }

    public void deleteMovie(long id){
         movieRepo.deleteById(id);
    }
}
