package com.nec.demo;

import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author amrmalaj
 *
 */
//@SpringBootApplication
@EnableAutoConfiguration(exclude = CamelAutoConfiguration.class)
@EntityScan("com.loyality.dao.entities")
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

}
