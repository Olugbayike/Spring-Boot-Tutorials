package com.sot.customUserStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.sot.customUserstore.BusinessLayer.adapters","com.sot.customUserstore.BusinessLayer.entities","com.sot.customUserstore.BusinessLayer.services","com.sot.customUserstore.BusinessLayer.configs","com.sot.customUserstore.presentationLayer","com.sot.customUserstore.persistence"})
@SpringBootApplication
public class CustomUserStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomUserStoreApplication.class, args);
	}

}
