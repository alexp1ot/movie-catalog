package com.example.moviecatalog.service;

import com.example.moviecatalog.entity.Movie; //сущность фильма(таблица мувис)
import com.example.moviecatalog.repository.MovieRepository; //интерфейс для работы с БД через JPA
import org.springframework.stereotype.Service;//помечает класс как сервисный слой Spring

import java.util.List;

//логика работы, прокидываю вызовы в repository, но потом сюда можно вынести проверки, фильтры и т.д.

@Service
public class MovieService {
    //Repository через конструктор, спринг сам создаст объект
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //получить все фильмы для вывода каталога на главной
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    //сохранение save() сам понимает что если id пустой то создать, если нет - обновить существующий
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    //поиск по id нужен для открытия формы редактирования, если фильма нет null
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    //удаление по id
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
