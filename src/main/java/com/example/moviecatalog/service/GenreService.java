package com.example.moviecatalog.service;

import com.example.moviecatalog.entity.Genre;//сущность жанра(таблица жанры)
import com.example.moviecatalog.repository.GenreRepository;//Интерфейс для работы с БД через JPA
import org.springframework.stereotype.Service;//Помечает класс как сервисный слой Spring

import java.util.List;

//логика работы с жанрами, пока просто получение данных из Repository

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    //все жанры для отображения списка и выбора фильма
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
