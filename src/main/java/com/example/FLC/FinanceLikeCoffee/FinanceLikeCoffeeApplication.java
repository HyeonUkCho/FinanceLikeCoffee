package com.example.FLC.FinanceLikeCoffee;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FinanceLikeCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceLikeCoffeeApplication.class, args);
	}

}
