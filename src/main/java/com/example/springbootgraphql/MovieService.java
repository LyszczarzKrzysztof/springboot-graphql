package com.example.springbootgraphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(int limit) {
        return movieRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        movieRepository.save(new Movie("KL","www.film1.pl"));
        movieRepository.save(new Movie("bd","www.film2.pl"));
    }

    public Movie save(String name, String url) {
        return movieRepository.save(new Movie(name, url));
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }
}
