package com.example.FLC.FinanceLikeCoffee.controller;

import com.example.FLC.FinanceLikeCoffee.Utils.UAParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/studydetail")
public class StudyDetailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/stock_begin")
    public String home(Model model, HttpServletRequest request) {
        logger.info("stock_begin page assessed.......");
        return "/studydetail/stock_begin";
    }

}
