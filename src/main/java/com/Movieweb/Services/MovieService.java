package com.Movieweb.Services;

import com.Movieweb.DTO.MovieDTO;
import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;


    public Movie createUser(MovieDTO request){
        Movie movie = new Movie();
        movie.setMoviereview(request.getMoviereview());
        movie.setMovieproduced(request.getMovieproduced());
        movie.setMoviename(request.getMoviename());
        return movieRepo.save(movie);
    }

}
