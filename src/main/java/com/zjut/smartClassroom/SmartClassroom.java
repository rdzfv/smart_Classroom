package com.zjut.smartClassroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjut.smartClassroom.dataObject.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = {"com.zjut.smartClassroom"})
@RestController
@MapperScan("com.zjut.smartClassroom.repository")
public class SmartClassroom extends WebMvcConfigurerAdapter {

	//	@RequestMapping("/")
//	public String home(){
//		return "hello world";
//	}
	public static void main(String[] args) {
		SpringApplication.run(SmartClassroom.class, args);
	}
}

