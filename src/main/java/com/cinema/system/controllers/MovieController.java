package com.cinema.system.controllers;

import com.cinema.system.domain.entities.Movie;
import com.cinema.system.dto.MovieDTO;
import com.cinema.system.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/movies-list")
    public ResponseEntity<List<MovieDTO>> booksList() {
        List<Movie> movies = movieService.findAllMovies();
        if (movies != null) {
            List<MovieDTO> allDTOMovies = new ArrayList<>();
            movies.forEach(movie -> {
                allDTOMovies.add(toMovieDTO(movie));
            });
            System.out.println("size: " + allDTOMovies.size());
            System.out.println("size: " + allDTOMovies.get(0).getDuration());
            return ResponseEntity.ok().body(allDTOMovies);
        }
        return ResponseEntity.notFound().build();
    }

    public static MovieDTO toMovieDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .producer(movie.getProducer())
                .duration(movie.getDuration())
                .build();
    }
}
