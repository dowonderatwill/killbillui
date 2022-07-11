package com.example.ckpspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan
//@EnableConfigurationProperties
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.example.ckpspringbootapp.util.*")
@ComponentScan("com.example.ckpspringbootapp.*")
public class CkpspringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CkpspringbootappApplication.class, args);
	}

}
