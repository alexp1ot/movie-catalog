package com.example.moviecatalog.controller;

import com.example.moviecatalog.service.MovieService;

import org.springframework.stereotype.Controller; //контроллер для обработки запросов
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;//обработка get запросов

//контроллер приложения отвечающитй за отображение главной страницы

@Controller
public class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String index(Model model) {

        //получаю все фильмы из базы  передаю их в шаблон
        model.addAttribute("movies", movieService.findAll());

        return "index";
    }
}
