package com.cinema.system.controllers;

import com.cinema.system.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final MovieService movieService;

    @GetMapping({"/", ""})
    public String index(Model model) {
        if (movieService.findAllMovies().size() > 0) {
            model.addAttribute("movies", movieService.findAllMovies());
        }
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping("/movie/{id}")
    public String getMoviePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("books", movieService.findById(id));
        return "moviesList";
    }
}
