package com.example.FLC.FinanceLikeCoffee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        logger.info("home page assessed.......");
        logger.info("request ip : " + getClientIp(request));
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model, HttpServletRequest request) {
        logger.info("about page assessed.......");
        logger.info("request ip : " + getClientIp(request));
        return "about";
    }

    @GetMapping("/FAQ")
    public String FAQ(Model model, HttpServletRequest request) {
        logger.info("FAQ page assessed.......");
        logger.info("request ip : " + getClientIp(request));
        return "FAQ";
    }

    @GetMapping("/agree")
    public String agree(Model model, HttpServletRequest request) {
        logger.info("agree page assessed.......");
        logger.info("request ip : " + getClientIp(request));
        return "agree";
    }

    public String getClientIp(HttpServletRequest request) {
        String LOCALHOST_IPV4 = "127.0.0.1";
        String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if(!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

}
