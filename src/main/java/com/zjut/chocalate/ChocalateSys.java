package com.zjut.chocalate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = {"com.zjut.chocalate"})
@RestController
@MapperScan("com.zjut.chocalate.repository")
public class ChocalateSys extends WebMvcConfigurerAdapter {

	//	@RequestMapping("/")
//	public String home(){
//		return "hello world";
//	}
	public static void main(String[] args) {
		SpringApplication.run(ChocalateSys.class, args);
	}
}

