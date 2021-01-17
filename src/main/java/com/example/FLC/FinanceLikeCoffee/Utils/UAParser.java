package com.example.FLC.FinanceLikeCoffee.Utils;

import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UAParser {

    UserAgentStringParser userAgentStringParser;

    public UAParser() {
        this.userAgentStringParser = UADetectorServiceFactory.getResourceModuleParser();

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
}
