package com.example.moviecatalog.controller;

import com.example.moviecatalog.entity.Movie;
import com.example.moviecatalog.service.GenreService;
import com.example.moviecatalog.service.MovieService;

import org.springframework.stereotype.Controller;//контроллер для обработки запросов
import org.springframework.ui.Model; //передача данных в html

import org.springframework.web.bind.annotation.GetMapping;//обработка get запросов
import org.springframework.web.bind.annotation.ModelAttribute;//автоматическое заполнение объекта из формы
import org.springframework.web.bind.annotation.PostMapping;//обработка post запросов
import org.springframework.web.bind.annotation.PathVariable;//получение параметра из url

//контроллер для работы со страницами фильмов

@Controller
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService) {

        this.movieService = movieService;
        this.genreService = genreService;
    }

    //открытие формы создания
    @GetMapping("/movies/new")
    public String showCreateForm(Model model) {

        //пустой объект для привязки формы
        model.addAttribute("movie", new Movie());

        //жанры для выпадающего списка
        model.addAttribute("genres", genreService.findAll());

        return "movie-form";
    }

    //удаление по id
    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {

        movieService.deleteById(id);

        //возврат на главную
        return "redirect:/";
    }

    //открытие формы редактирования
    @GetMapping("/movies/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        //загрузка из базы
        Movie movie = movieService.findById(id);

        //отправлка в форму
        model.addAttribute("movie", movie);

        model.addAttribute("genres", genreService.findAll());

        return "movie-form";
    }

    //сохранение фильма после отправки формы
    @PostMapping("/movies")
    public String createMovie(@ModelAttribute Movie movie) {

        //авто создать или обновить
        movieService.save(movie);

        return "redirect:/";
    }
}