package com.example.FLC.FinanceLikeCoffee.domain.log;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitLogRepositoryTest {

    @Autowired
    VisitLogRepository visitLogRepository;

    @After
    public void cleanup() {
        visitLogRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testInsertVisitLog() {
        VisitLog visitLog = new VisitLog();
        visitLog.setChannelType("PC");
        visitLog.setVisitorInfo("TEST");
        visitLog.setIp("127.0.0.1");

        visitLogRepository.save(visitLog);
    }
}
