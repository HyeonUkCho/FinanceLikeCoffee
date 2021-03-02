package com.example.FLC.FinanceLikeCoffee.config;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptConfigTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Test
    public void encryptDecryptTest() {

        String orgText = "ticklemickle1@#";

        String encText = jasyptStringEncryptor.encrypt(orgText);

        logger.info("##### encText : {}", encText);

        String decText = jasyptStringEncryptor.decrypt(encText);

        Assertions.assertThat(decText).isEqualTo(orgText);
    }
}
