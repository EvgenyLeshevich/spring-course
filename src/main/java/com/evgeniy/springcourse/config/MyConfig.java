package com.evgeniy.springcourse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.evgeniy.springcourse")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
}
