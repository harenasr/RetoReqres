package com.entelgy.harenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.entelgy.harenas" })
public class HarenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarenasApplication.class, args);
	}

}
