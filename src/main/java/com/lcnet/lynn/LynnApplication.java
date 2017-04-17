package com.lcnet.lynn;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LynnApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication();
		app.setBannerMode(Banner.Mode.OFF);
		app.run(LynnApplication.class, args);
//		SpringApplication.run(LynnApplication.class, args);
	}
}
