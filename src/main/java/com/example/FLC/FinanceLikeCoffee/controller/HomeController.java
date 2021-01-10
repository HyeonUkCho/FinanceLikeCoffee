package com.example.FLC.FinanceLikeCoffee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/")
    public String home(Model model) {
        logger.info("home page assessed.......");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        logger.info("home page assessed.......");
        return "about";
    }

    @GetMapping("/FAQ")
    public String FAQ(Model model) {
        logger.info("home page assessed.......");
        return "FAQ";
    }
}
