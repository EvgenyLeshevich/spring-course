package com.evgeniy.springcourse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.evgeniy.springcourse")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

}
