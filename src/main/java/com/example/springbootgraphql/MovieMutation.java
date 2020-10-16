package com.example.springbootgraphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMutation implements GraphQLMutationResolver {
    private MovieService movieService;

    @Autowired
    public MovieMutation(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie createMovie(String name, String url) {
        return movieService.save(name, url);
    }
}
