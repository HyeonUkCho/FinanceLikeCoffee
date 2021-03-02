package com.example.FLC.FinanceLikeCoffee.Utils;

import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class UAParser {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    UserAgentStringParser userAgentStringParser;

    Parser uaParser;

    public UAParser() {
        this.userAgentStringParser = UADetectorServiceFactory.getResourceModuleParser();
        this.uaParser = new Parser();

    }
    public String getClientRequestInfo(HttpServletRequest request) {
        ReadableUserAgent ua = userAgentStringParser.parse(request.getHeader("User-Agent"));

        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(ua.getName()).append("/"); // 필요
        sb.append("Version: ").append(ua.getVersionNumber().toVersionString()).append("/"); // 필요
        sb.append("Type: ").append(ua.getTypeName()).append("/"); // 필요
        sb.append("Family: ").append(ua.getFamily()).append("/"); // 필요
//        sb.append("URL: ").append(ua.getUrl()).append("\n");
//        sb.append("Icon: ").append(ua.getIcon()).append("\n");
//        sb.append("Producer: ").append(ua.getProducer()).append("\n");
//        sb.append("Producer URL: ").append(ua.getProducerUrl()).append("\n");요

        sb.append("Device Category Name: ").append(ua.getDeviceCategory().getName()).append("/"); // 필요
//        sb.append("Device Category Icon: ").append(ua.getDeviceCategory().getIcon()).append("\n");
//        sb.append("Device Category Info URL: ").append(ua.getDeviceCategory().getInfoUrl()).append("\n");

        OperatingSystem os = ua.getOperatingSystem();
        sb.append("OS Name: ").append(os.getName()).append("\n"); // 필요
//        sb.append("OS Family Name: ").append(os.getFamilyName()).append("\n");
//        sb.append("OS Version Number: ").append(os.getVersionNumber().toVersionString()).append("\n");
//        sb.append("OS URL: ").append(os.getUrl()).append("\n");
//        sb.append("OS Icon: ").append(os.getIcon()).append("\n");
//        sb.append("OS Company: ").append(os.getProducer()).append("\n");
//        sb.append("OS Company URL: ").append(os.getProducerUrl()).append("\n");

        return sb.toString();

        // ReadableDevieCategory.Category를 반환한다.
        // PERSONAL_COMPUTER, SMARTPHONE, TABLET, SMART_TV, WEARABLE_COMPUTER, GAME_CONSOLE, PDA, OTHER, UNKNOWN을 반환한다.
        // userAgentStringParser.parse(userAgent).getDeviceCategory().getCategory().toString();
        // ReadableOperatingSystemFamily.OperatingSystemFamily을 반환한다.
        // WINDOWS, MAC_OS, BSD, LINUX, ANDROID, IOS, BLACKBERRY_OS, UNKNOWN 등을 반환한다.
        // parser.parse(userAgent).getOperatingSystem().getFamily();
        // UserAgentType을 반환한다.
        // BROWSER, MOBILE_BROWSER, OFFLINE_BROWSER, ROBOT, LIBRARY, UNKNOWN 등을 반환한다.
        // parser.parse(userAgent).getType(); // UserAgentFamily를 반환한다.
        // CHROME, CHROME_MOBILE, FIREFOX, MOBILE_FIREFOX, SAFARI, MOBILE_SAFARI, IE, IE_MOBILE, UNKNOWN 등을 반환한다.
        // parser.parse(userAgent).getFamily();
    }

    public String getClientRequestInfo2(HttpServletRequest request) {
        String uaString = request.getHeader("User-Agent");
        logger.info("User-agent : [" + uaString + "]");
        Client c = uaParser.parse(uaString);
        return c.userAgent.family + " / " + c.os.family + " / " + c.device.family;
    }

    public String checkPcOrMobileOrTablet(Device device) {
        if (device.isMobile()) {
            return "MOBILE";
        } else if (device.isTablet()) {
            return "TABLET";
        } else {
            return "PC";
        }
    }

    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        logger.debug("> X-FORWARDED-FOR : " + ip);

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            logger.debug("> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            logger.debug(">  WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            logger.debug("> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            logger.debug("> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
            logger.debug("> getRemoteAddr : "+ip);
        }
        logger.debug("> Result : IP Address : "+ip);

        return ip;
    }
}
