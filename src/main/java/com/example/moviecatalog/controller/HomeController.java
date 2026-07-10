package com.example.moviecatalog.controller;

import com.example.moviecatalog.service.MovieService;

import org.springframework.stereotype.Controller; //контроллер для обработки запросов
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;//обработка get запросов
import org.springframework.web.bind.annotation.RequestParam;

//контроллер приложения отвечающитй за отображение главной страницы

@Controller
public class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(name = "query", required = false) String query,
            Model model) {

        //если есть поисковый запрос, сервис вернет совпадения
        //если запроса нет, сервис вернет все фильмы
        model.addAttribute("movies", movieService.search(query));

        //возвращаю запрос обратно в html,
        //чтобы после поиска текст оставался в поле
        model.addAttribute("query", query);

        return "index";
    }
}
