package com.Movieweb.Mapper;

import com.Movieweb.DTO.Requests.MovieCreationRequest;
import com.Movieweb.DTO.Requests.MovieUpdateRequest;
import com.Movieweb.DTO.Response.MovieResponse;
import com.Movieweb.Models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toMovie(MovieCreationRequest request);
    MovieResponse toMovieResponse(Movie movie);

    void updateMovie(@MappingTarget Movie movie, MovieUpdateRequest request);
}
