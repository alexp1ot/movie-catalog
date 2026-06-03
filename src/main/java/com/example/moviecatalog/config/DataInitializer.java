package com.example.moviecatalog.config;

import com.example.moviecatalog.entity.Genre;
import com.example.moviecatalog.repository.GenreRepository;//работа с таблицей жанров через jpa
import org.springframework.boot.CommandLineRunner;//код выполнится автоматически при запуске приложения
import org.springframework.context.annotation.Bean;//регистрация объекта в спринг
import org.springframework.context.annotation.Configuration;//конфигурационный класс

//инициализация стартовых данных при первом запуске добавляет стандартные жанры в базу

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(GenreRepository genreRepository) {

        //args — аргументы запуска, пока не использую
        return args -> {

            //если жанров нет заполнить таблицу начальными данными
            if (genreRepository.count() == 0) {

                genreRepository.save(new Genre("Боевик"));
                genreRepository.save(new Genre("Комедия"));
                genreRepository.save(new Genre("Фантастика"));
                genreRepository.save(new Genre("Драма"));
                genreRepository.save(new Genre("Ужасы"));

                //тест
                System.out.println("Жанры добавлены в базу");
            }
        };
    }
}
