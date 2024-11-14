package com.Movieweb.Services;

import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Requests.MovieUpdateRequest;
import com.Movieweb.DTO.Response.ApiResponse;
import com.Movieweb.DTO.Response.MovieResponse;
import com.Movieweb.Exception.ErrorCode;
import com.Movieweb.Exception.MovieException;
import com.Movieweb.Mapper.MovieMapper;
import com.Movieweb.Models.Movie;
import com.Movieweb.Repository.MovieRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private final MovieRepo movieRepo;
    @Autowired
    MovieMapper movieMapper;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    public  @ResponseBody MovieResponse createUser(MovieCreationRequest request){
        if(movieRepo.existsByMovieName(request.getMovieName()))
            throw new MovieException(ErrorCode.USER_EXISTED);
        Movie movie = movieMapper.toMovie(request);
        return movieMapper.toMovieResponse(movieRepo.save(movie));
    }

    public List<MovieResponse> getMovie() {
        return movieRepo.findAll().stream()
                .map(movieMapper::toMovieResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse getMovie(long id){
         return movieRepo.findById(id).map(movieMapper::toMovieResponse).orElseThrow(() -> new RuntimeException("Id doesn't exist"));
    }

    public MovieResponse updateMovie(long id, MovieUpdateRequest request){
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new RuntimeException("Id doesn't exit"));
        movieMapper.updateMovie(movie,request);
        movieRepo.save(movie);
        return movieMapper.toMovieResponse(movie);
    }

    public void deleteMovie(long id){
         movieRepo.deleteById(id);
    }
}
