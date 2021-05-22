package com.example.FLC.FinanceLikeCoffee.controller;

import com.example.FLC.FinanceLikeCoffee.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request, Device device) {
        logger.info("home page assessed.....");
        homeService.saveVisitLog(request,device,"home");
        return "home";
    }

    @GetMapping("/ticklemickle")
    public String homeByLink(@RequestParam("link") String fromLink, Model model, HttpServletRequest request, Device device) {
        logger.info("home page assessed.....fromLink : " + fromLink);
        homeService.saveVisitLog(request,device,"home-" + fromLink);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model, HttpServletRequest request, Device device) {
        logger.info("about page assessed.......");
        homeService.saveVisitLog(request,device,"about");
        return "about";
    }

    @GetMapping("/FAQ")
    public String FAQ(Model model, HttpServletRequest request, Device device) {
        logger.info("FAQ page assessed.......");
        homeService.saveVisitLog(request,device,"FAQ");
        return "FAQ";
    }

    @GetMapping("/agree")
    public String agree(Model model, HttpServletRequest request, Device device) {
        logger.info("agree page assessed.......");
        homeService.saveVisitLog(request,device,"agree");
        return "agree";
    }

    @GetMapping("/interest_survey")
    public String survey(Model model, HttpServletRequest request, Device device) {
        logger.info("survey page assessed.......");
        homeService.saveVisitLog(request,device,"survey");
        return "interest_survey";
    }
    @GetMapping("/realestate_detail")
    public String realestate_detail(Model model, HttpServletRequest request, Device device) {
        logger.info("realestate_detail page assessed.......");
        homeService.saveVisitLog(request,device,"realestate_detail");
        return "studydetail/realestate_detail";
    }
}
