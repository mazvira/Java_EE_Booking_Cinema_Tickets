package com.cinema.system.services;

import com.cinema.system.domain.entities.Movie;
import com.cinema.system.domain.entities.Ticket;
import com.cinema.system.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public Movie createMovie(String name, String producer, double duration) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setProducer(producer);
        movie.setDuration(duration);
        return movieRepository.save(movie);
    }

    @Transactional
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public Movie findById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }
}
