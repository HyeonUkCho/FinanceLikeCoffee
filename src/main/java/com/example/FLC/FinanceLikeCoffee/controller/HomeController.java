package com.example.FLC.FinanceLikeCoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("page/home")
    public void home(Model model) {

    }

    @GetMapping("page/about")
    public void about(Model model) {

    }
}
