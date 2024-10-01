package com.Movieweb.Services;

import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Response.MovieResponse;
import com.Movieweb.Exception.ErrorCode;
import com.Movieweb.Exception.MovieException;
import com.Movieweb.Mapper.MovieMapper;
import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    private final MovieRepo movieRepo;
    @Autowired
    MovieMapper movieMapper;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    public MovieResponse createUser(MovieCreationRequest request){
        if(movieRepo.existsByMoviename(request.getMoviename()))
            throw new MovieException(ErrorCode.USER_EXISTED);
        Movie movie = movieMapper.toMovie(request);
        return movieMapper.toMovieResponse(movieRepo.save(movie));
        
    }
    public List<Movie> getMovie(){
        return movieRepo.findAll();
    }

    public Movie getMovie(long id){
        return movieRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Movie updateMovie(long id, MovieCreationRequest request){
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
