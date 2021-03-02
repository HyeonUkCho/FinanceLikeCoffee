package com.example.FLC.FinanceLikeCoffee.service;

import com.example.FLC.FinanceLikeCoffee.Utils.UAParser;
import com.example.FLC.FinanceLikeCoffee.domain.log.VisitLog;
import com.example.FLC.FinanceLikeCoffee.domain.log.VisitLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class HomeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    UAParser uaParser;
    VisitLogRepository visitLogRepository;

    @Autowired
    public HomeService(UAParser uaParser, VisitLogRepository visitLogRepository) {
        this.uaParser = uaParser;
        this.visitLogRepository = visitLogRepository;
    }

    public void saveVisitLog(HttpServletRequest request, Device device, String pageName){
        logger.debug("saveVisitLog start");
        String channelType = uaParser.checkPcOrMobileOrTablet(device);
        logger.debug("saveVisitLog start1");
        String ip          = uaParser.getClientIp(request);
        logger.debug("saveVisitLog start2");
        String visitorInfo = uaParser.getClientRequestInfo2(request);
        logger.debug("saveVisitLog start3");

        VisitLog visitLog = VisitLog.builder()
                .ip(ip)
                .channelType(channelType)
                .visitorInfo(visitorInfo)
                .pageName(pageName)
                .build();

        visitLogRepository.save(visitLog);
        logger.debug("saveVisitLog start4");
    }
}
