package com.example.moviecatalog.repository;

import com.example.moviecatalog.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //поиск сразу по названию, описанию и названию жанра
    @Query("""
            select movie
            from Movie movie
            join movie.genre genre
            where lower(movie.title) like lower(concat('%', :query, '%'))
               or lower(movie.description) like lower(concat('%', :query, '%'))
               or lower(genre.name) like lower(concat('%', :query, '%'))
            """)
    List<Movie> search(@Param("query") String query);
}