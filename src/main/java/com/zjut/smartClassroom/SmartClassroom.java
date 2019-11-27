package com.zjut.smartClassroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjut.smartClassroom.Dao.*;
import com.zjut.smartClassroom.dataObject.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = {"com.zjut.smartClassroom"})
@RestController
@MapperScan("com.zjut.smartClassroom.Dao")
public class SmartClassroom extends WebMvcConfigurerAdapter {

	//	@RequestMapping("/")
//	public String home(){
//		return "hello world";
//	}
	@Autowired(required = false)
	private StudentDOMapper userDOMapper;

	@RequestMapping("/")
	public String index(){
		StudentDO userDO=userDOMapper.selectByPrimaryKey(1);
		//若获取的用户信息不存在


		if(userDO == null){
			return "对象用户不存在";
		}else{
			return userDO.getStudentName();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(SmartClassroom.class, args);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("*");
	}
}

