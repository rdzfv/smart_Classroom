package com.zjut.chocalate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories("com.zjut.chocalate.repository")
public class JpaConfiguration {

}
