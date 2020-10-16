package com.example.springbootgraphql;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieQuery implements GraphQLQueryResolver {
    private MovieService movieService;

    @Autowired
    public MovieQuery(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovies(int limit) {
        return movieService.getMovies(limit);
    }

    public Optional<Movie> getMovieById(Long id){
        return movieService.findById(id);
    }
}
